package com.sda.moviedb.service;

import com.sda.moviedb.entity.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> findAll();

    public Movie findById(Long ID);

    public void save(Movie theMovie);

    public void delete(Long ID);

    public List<String> ratedMovie();

}
