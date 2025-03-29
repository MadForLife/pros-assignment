package com.pros.prosassignment.dto;

public class RouteRequestDTO {

    private String origin;
    private String destination;
    private Integer maxFlights;

    public RouteRequestDTO() {
    }

    public RouteRequestDTO(String origin, String destination, Integer maxFlights) {
        this.origin = origin;
        this.destination = destination;
        this.maxFlights = maxFlights;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getMaxFlights() {
        return maxFlights;
    }

    @Override
    public String toString() {
        return "RouteRequestDTO{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
