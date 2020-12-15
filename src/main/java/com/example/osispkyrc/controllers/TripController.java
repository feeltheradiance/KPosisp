package com.example.osispkyrc.controllers;

import com.example.osispkyrc.models.Trip;
import com.example.osispkyrc.models.User;
import com.example.osispkyrc.repository.TripRepository;
import com.example.osispkyrc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Controller
@RequestMapping("/trip")
public class TripController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TripRepository tripRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String tripList(@AuthenticationPrincipal User user,Model model) {
        model.addAttribute("user", user);
        model.addAttribute("trips", tripRepository.findAll());
        return "tripList";
    }

    @GetMapping("/new")
    public String addTrip(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "tripNew";
    }

    @PostMapping("/new")
    public String addTrip(@AuthenticationPrincipal User user,
                             @RequestParam String fromCity,
                             @RequestParam String toCity,
                             @RequestParam String date,
                             @RequestParam Integer seats,
                             @RequestParam(required = false, defaultValue = "") String comment,
                             Model model) throws ParseException {
        Trip trip = new Trip(fromCity, toCity, seats, date, comment, user);
        tripRepository.save(trip);
        Iterable<Trip> trips = tripRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("trips", trips);
        return "redirect:/main";
    }

    @GetMapping("{trip}")
    public String tripShow(@PathVariable Trip trip, @AuthenticationPrincipal User user, Model model) {
        String notInSeaters = "yes";
        if (!trip.getSeaters().isEmpty()) {
            for (User seater :trip.getSeaters()) {
                if (seater.getUsername().equals(user.getUsername())) {
                    notInSeaters = "no";
                    break;
                }
            }
        }
        model.addAttribute("trip", trip);
        model.addAttribute("user", user);
        model.addAttribute("notinseaters", notInSeaters);
        return "tripShow";
    }

    @PostMapping("{trip}")
    public String tripAddUser(@PathVariable Trip trip, @AuthenticationPrincipal User user, Model model) {
        trip.setSeats(trip.getSeats()-1);
        trip.getSeaters().add(user);
        tripRepository.save(trip);
        user.getTrips().add(trip);
        userRepository.save(user);
        model.addAttribute("user", user);
        model.addAttribute("trip", trip);
        return "redirect:/main";
    }
}
