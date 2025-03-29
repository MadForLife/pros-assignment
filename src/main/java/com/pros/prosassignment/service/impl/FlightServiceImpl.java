package com.pros.prosassignment.service.impl;

import com.pros.prosassignment.dto.RouteRequestDTO;
import com.pros.prosassignment.dto.RouteResponseDTO;
import com.pros.prosassignment.service.FlightService;
import com.pros.prosassignment.model.City;
import com.pros.prosassignment.util.FlightGraph;
import com.pros.prosassignment.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightGraph flightGraph;

    public FlightServiceImpl(FlightGraph flightGraph) {
        this.flightGraph = flightGraph;
    }

    @Override
    public List<RouteResponseDTO> findRoutes(RouteRequestDTO routeRequestDTO) {

        String origin = routeRequestDTO.getOrigin();
        String destination = routeRequestDTO.getDestination();
        Integer maxFlights = routeRequestDTO.getMaxFlights();


        List<Route> routes = flightGraph.findAllRoutes(new City(origin, origin), new City(destination, destination));

        if (maxFlights != null) {
            routes = routes.stream()
                    .filter(route -> route.getCities().size() <= maxFlights + 1)
                    .toList();
        }

        return routes.stream()
                .map(route -> new RouteResponseDTO(
                        route.getCities().stream()
                                .map(City::getCode)
                                .collect(Collectors.toList()),
                        route.getTotalPrice())).collect(Collectors.toList());
    }
}
