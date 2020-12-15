package com.example.osispkyrc.models;

import javax.persistence.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String fromCity;
    private String toCity;
    private Integer seats;
    private LocalDate date;
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany
    private Set<User> seaters;

    public Trip() {}

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Set<User> getSeaters() {
        return seaters;
    }

    public void setSeaters(Set<User> seaters) {
        this.seaters = seaters;
    }

    public Trip(String fromCity, String toCity, Integer seats, String date, String comment, User author) throws ParseException {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.seats = seats;
        this.date = LocalDate.parse(date);
        this.comment = comment;
        this.author = author;
        this.seaters = new HashSet<>();
    }

    public String getAuthorName() {
        return author.getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStringDate() {
        return date.toString();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
