package com.example.flight.controller;

import com.example.flight.model.FlightSearchRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class SelectPortController {

    @GetMapping("/selectPorts")
    public String showSelectPortsPage(Model model) {
        // Dummy port list (veritabanına bağlayana kadar sabit)
        List<String> ports = Arrays.asList("IST", "ESB", "ADB", "SAW", "AYT");

        model.addAttribute("ports", ports);
        model.addAttribute("flightSearch", new FlightSearchRequest());

        return "selectPorts";
    }

    @PostMapping("/selectPorts")
    public String handleSearch(@ModelAttribute FlightSearchRequest flightSearchRequest) {
        // Şimdilik sadece kontrol amaçlı log veya kontrol yapılabilir
        System.out.println("Arama bilgileri: " + flightSearchRequest.getDeparturePort() + " -> " + flightSearchRequest.getArrivalPort());
        return "redirect:/availFlights"; // Bir sonraki sayfaya yönlendir
    }
}
