package com.pros.prosassignment.dto;

import java.math.BigDecimal;
import java.util.List;

public class RouteResponseDTO {

    private List<String> route;
    private BigDecimal price;

    public RouteResponseDTO(List<String> route, BigDecimal price) {
        this.route = route;
        this.price = price;
    }

    public List<String> getRoute() {
        return route;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
