package com.pros.prosassignment.controller;

import com.pros.prosassignment.dto.RouteRequestDTO;
import com.pros.prosassignment.dto.RouteResponseDTO;
import com.pros.prosassignment.service.FlightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/routes")
    public List<RouteResponseDTO> getRoutes(@RequestBody RouteRequestDTO routeRequestDTO) {
        return flightService.findRoutes(routeRequestDTO);
    }
}
