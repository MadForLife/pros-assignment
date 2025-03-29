package com.pros.prosassignment.service;

import com.pros.prosassignment.dto.RouteRequestDTO;
import com.pros.prosassignment.dto.RouteResponseDTO;

import java.util.List;

public interface FlightService {

    List<RouteResponseDTO> findRoutes(RouteRequestDTO routeRequestDTO);
}
