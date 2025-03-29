package com.pros.prosassignment.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Route {

    private List<City> cities;
    private BigDecimal totalPrice;

    public Route() {
        this(new ArrayList<>(), BigDecimal.ZERO);
    }

    public Route(List<City> cities, BigDecimal totalPrice) {
        this.cities = cities;
        this.totalPrice = totalPrice;
    }

    public List<City> getCities() {
        return cities;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

//    @Override
//    public String toString() {
//        return "Route{" +
//                "cities=" + cities +
//                ", totalPrice=" + totalPrice +
//                '}';
//    }

        @Override
    public String toString() {
        String cityCodes = String.join(", ", cities.stream().map(City::getCode).toList());
        return cityCodes + ", " + totalPrice;
    }
}
