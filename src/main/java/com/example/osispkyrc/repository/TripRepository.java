package com.example.osispkyrc.repository;

import com.example.osispkyrc.models.Trip;
import com.example.osispkyrc.models.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Long> {
    List<Trip> findByDate(LocalDate date);
    List<Trip> findByAuthor(User user);
}
