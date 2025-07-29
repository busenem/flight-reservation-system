package com.example.flight.controller;

import com.example.flight.entity.Passenger;
import com.example.flight.model.PassengerInfoForm;
import com.example.flight.repository.PassengerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PassengerInfoController {

    private final PassengerRepository passengerRepository;

    public PassengerInfoController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @PostMapping("/passengerInfo")
    public String showPassengerForm(@RequestParam("flightId") Long flightId,
                                    @RequestParam("passengerCount") int passengerCount,
                                    Model model) {

        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < passengerCount; i++) {
            passengers.add(new Passenger());
        }

        PassengerInfoForm form = new PassengerInfoForm();
        form.setPassengers(passengers);
        form.setFlightId(flightId);

        model.addAttribute("form", form);
        return "passengerInfo";
    }

    @PostMapping("/savePassengers")
    public String savePassengers(@ModelAttribute PassengerInfoForm form) {
        String pnr = UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        for (Passenger passenger : form.getPassengers()) {
            passenger.setFlightId(form.getFlightId());
            passenger.setPnr(pnr);
            passengerRepository.save(passenger);
        }

        return "redirect:/payment?pnr=" + pnr;
    }
}

