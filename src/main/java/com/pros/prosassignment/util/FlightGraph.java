package com.pros.prosassignment.util;

import com.pros.prosassignment.model.City;
import com.pros.prosassignment.model.Flight;
import com.pros.prosassignment.model.Route;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class FlightGraph {

    private Map<City, List<Flight>> graph;

    public FlightGraph() {
        this.graph = new HashMap<City, List<Flight>>();
    }

    public void addFlight(Flight flight) {
        graph.putIfAbsent(flight.getDeparture(), new ArrayList<>());
        graph.get(flight.getDeparture()).add(flight);
    }

    public List<Route> findAllRoutes(City origin, City destination) {

        List<Route> routes = new ArrayList<>();
        Stack<Route> stack = new Stack<>();

        stack.push(new Route(List.of(origin), BigDecimal.ZERO));

        while (!stack.isEmpty()) {

            Route currentRoute = stack.pop();
            List<City> currentPath = currentRoute.getCities();

            City lastCity = currentPath.getLast();

            if (lastCity.equals(destination)) {
                routes.add(currentRoute);
            }

            if (graph.containsKey(lastCity)) {

                for (Flight flight : graph.get(lastCity)) {
                    if (!currentPath.contains(flight.getArrival())) {
                        List<City> newPath = new ArrayList<>(currentPath);
                        newPath.add(flight.getArrival());
                        BigDecimal totalPrice = currentRoute.getTotalPrice().add(flight.getPrice());
                        stack.push(new Route(newPath, totalPrice));
                    }
                }
            }
        }

        routes.sort(Comparator.comparing(Route::getTotalPrice));
        return routes;
    }

    public void printRoutes(List<Route> routes) {
        for (Route route : routes) {
            System.out.println(route);
        }
    }

    @PostConstruct
    public void initialize() {
        City sof = new City("SOF", "Sofia");
        City ist = new City("IST", "Istanbul");
        City lon = new City("LON", "London");
        City fra = new City("FRA", "Frankfurt");
        City dub = new City("DUB", "Dubai");
        City sin = new City("SIN", "Singapore");
        City cmb = new City("CMB", "Colombo");
        City mle = new City("MLE", "Malé");
        City nyc = new City("NYC", "New York");
        City lax = new City("LAX", "Los Angeles");
        City syd = new City("SYD", "Sydney");

        addFlight(new Flight(sof, ist, new BigDecimal(10)));
        addFlight(new Flight(ist, cmb, new BigDecimal(20)));
        addFlight(new Flight(cmb, mle, new BigDecimal(40)));

        addFlight(new Flight(sof, lon, new BigDecimal(30)));
        addFlight(new Flight(lon, mle, new BigDecimal(40)));
        addFlight(new Flight(sof, fra, new BigDecimal(25)));
        addFlight(new Flight(fra, sin, new BigDecimal(50)));
        addFlight(new Flight(sin, mle, new BigDecimal(20)));
        addFlight(new Flight(sof, dub, new BigDecimal(35)));
        addFlight(new Flight(dub, mle, new BigDecimal(30)));
        addFlight(new Flight(nyc, lon, new BigDecimal(100)));
        addFlight(new Flight(lax, syd, new BigDecimal(120)));
        addFlight(new Flight(lax, nyc, new BigDecimal(80)));
        addFlight(new Flight(syd, mle, new BigDecimal(90)));

    }

}
