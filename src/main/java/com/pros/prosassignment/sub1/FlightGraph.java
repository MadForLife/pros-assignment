package com.pros.prosassignment.sub1;

import java.math.BigDecimal;
import java.util.*;

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
}
