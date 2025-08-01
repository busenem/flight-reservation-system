package com.example.flight.repository;

import com.example.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDeparturePortAndArrivalPortAndDepartureDateAndCabin(
            String departurePort,
            String arrivalPort,
            LocalDate departureDate,
            String cabin
    );
}

