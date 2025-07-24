package com.example.flight.controller;

import com.example.flight.entity.Flight;
import com.example.flight.model.FlightSearchRequest;
import com.example.flight.repository.FlightRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AvailFlightsController {

    private final FlightRepository flightRepository;

    public AvailFlightsController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @PostMapping("/availFlights")
    public String showAvailableFlights(@ModelAttribute FlightSearchRequest flightSearchRequest, Model model) {
        List<Flight> flights = flightRepository.findByDeparturePortAndArrivalPortAndDepartureDateAndCabin(
                flightSearchRequest.getDeparturePort(),
                flightSearchRequest.getArrivalPort(),
                flightSearchRequest.getDepartureDate(),
                flightSearchRequest.getFlightType()
        );

        model.addAttribute("flights", flights);
        model.addAttribute("passengerCount", flightSearchRequest.getPassengerCount());
        model.addAttribute("selectedInfo", flightSearchRequest);

        return "availFlights";
    }
}
