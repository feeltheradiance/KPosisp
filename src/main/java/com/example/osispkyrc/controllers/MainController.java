package com.example.osispkyrc.controllers;

import com.example.osispkyrc.models.Trip;
import com.example.osispkyrc.models.User;
import com.example.osispkyrc.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("/")
    public String greeting( Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user,
                       @RequestParam(required = false, defaultValue = "") String filterFrom,
                       @RequestParam(required = false, defaultValue = "") String filterTo,
                       @RequestParam(required = false, defaultValue = "") String filterDate, Model model) {
        List<Trip> trips;
        if(filterDate != null && !filterDate.isEmpty()) {
            trips = tripRepository.findByDate(LocalDate.parse(filterDate));
            if (filterFrom != null && !filterFrom.isEmpty()) {
                trips.removeIf(trip -> !trip.getFromCity().equals(filterFrom));
            }
            if (filterTo != null && !filterTo.isEmpty()) {
                trips.removeIf(trip -> !trip.getToCity().equals(filterTo));
            }
        } else {
            trips = (List<Trip>)tripRepository.findAll();
            if (filterFrom != null && !filterFrom.isEmpty()) {
                trips.removeIf(trip -> !trip.getFromCity().equals(filterFrom));
            }
            if (filterTo != null && !filterTo.isEmpty()) {
                trips.removeIf(trip -> !trip.getToCity().equals(filterTo));
            }
        }
        model.addAttribute("user", user);
        model.addAttribute("trips", trips);
        model.addAttribute("filterFrom", filterFrom);
        model.addAttribute("filterTo", filterTo);
        model.addAttribute("filterDate", filterDate);
        return "main";
    }
}
