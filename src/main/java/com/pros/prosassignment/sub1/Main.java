package com.pros.prosassignment.sub1;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        City sofia = new City("SOF", "Sofia");
        City istanbul = new City("IST", "Istanbul");
        City colombo = new City("CMB", "Colombo");
        City male = new City("MLE", "Male");
        City dubai = new City("DXB", "Dubai");

        FlightGraph flightGraph = new FlightGraph();

        flightGraph.addFlight(new Flight(sofia, istanbul, BigDecimal.valueOf(10)));
        flightGraph.addFlight(new Flight(istanbul, colombo, BigDecimal.valueOf(30)));
        flightGraph.addFlight(new Flight(colombo, male, BigDecimal.valueOf(20)));
        flightGraph.addFlight(new Flight(sofia, dubai, BigDecimal.valueOf(50)));
        flightGraph.addFlight(new Flight(dubai, male, BigDecimal.valueOf(15)));
        flightGraph.addFlight(new Flight(istanbul, male, BigDecimal.valueOf(60)));

        List<Route> routes = flightGraph.findAllRoutes(sofia, male);
        flightGraph.printRoutes(routes);
    }
}
