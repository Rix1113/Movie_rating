package com.sda.moviedb.entity;

import javax.persistence.*;

@Entity
public class UserMovie {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

    private int rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovieId() {
        return movie;
    }

    public void setMovieId(Movie movie) {
        this.movie = movie;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
