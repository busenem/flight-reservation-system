package com.example.flight.model;

import com.example.flight.entity.Passenger;
import java.util.List;

public class PassengerInfoForm {

    private List<Passenger> passengers;
    private Long flightId;

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
