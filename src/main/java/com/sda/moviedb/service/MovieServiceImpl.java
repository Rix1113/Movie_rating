package com.sda.moviedb.service;

import com.sda.moviedb.entity.Movie;
import com.sda.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    

    @Autowired
    public MovieServiceImpl(MovieRepository theMovieRepository) {
        this.movieRepository = theMovieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long ID) {

        Optional<Movie> result = movieRepository.findById(ID);

        Movie theMovie = null;
        if (result.isPresent()) {
            theMovie = result.get();
        } else {
            // movie not found
            throw new RuntimeException("Did not find movie id -> " + ID);
        }
        return theMovie;
    }

    @Override
    public void save(Movie theMovie) {
        movieRepository.save(theMovie);
    }

    @Override
    public void delete(Long ID) {
        movieRepository.deleteById(ID);
    }

    @Override
    public List<String> ratedMovie() {
        List<Movie> allMovies = findAll();
        ArrayList<String> ratedMovieList = new ArrayList<>();
        for (Movie ratedMovie : allMovies) {
            if (ratedMovie.getRating() > 0) {
                ratedMovieList.add(ratedMovie.getName());
            }
        }
        Collections.sort(ratedMovieList);
        return ratedMovieList;
    }
}
