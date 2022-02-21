package com.tdd.flightmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data

public abstract class Flight {
    private String id;
    Set<Passenger> passengers = new HashSet<>();


    public Flight(String id) {
        this.id = id;
    }
    public Set<Passenger> getPassengersSet(){
        return Collections.unmodifiableSet(passengers);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
}
