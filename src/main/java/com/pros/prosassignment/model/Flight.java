package com.pros.prosassignment.model;

import java.math.BigDecimal;

public class Flight {

    private City departure;
    private City arrival;
    private BigDecimal price;

    public Flight(City departure, City arrival, BigDecimal price) {
        this.departure = departure;
        this.arrival = arrival;
        setPrice(price);
    }

    public City getDeparture() {
        return departure;
    }

    public City getArrival() {
        return arrival;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        this.price = price;
    }
}
