package com.sda.moviedb.vo;

import java.util.Set;

public class UserRatingVo {
    private String userName;
    private String email;
    private Set<MovieVo> movie;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<MovieVo> getMovie() {
        return movie;
    }

    public void setMovie(Set<MovieVo> movie) {
        this.movie = movie;
    }
}
