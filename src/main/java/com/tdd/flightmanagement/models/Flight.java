package com.tdd.flightmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data

public abstract class Flight {
    private String id;
    List<Passenger> passengers = new ArrayList<Passenger>();


    public Flight(String id) {
        this.id = id;
    }
    public List<Passenger> getPassengersList(){
        return Collections.unmodifiableList(passengers);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
}
