package com.sda.moviedb.controller;

import com.sda.moviedb.entity.Movie;
import com.sda.moviedb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    // Get list of movies
    @GetMapping("/movies")
    public String showMoviesList(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        List<String> ratedMovie = movieService.ratedMovie();
        model.addAttribute("ratedMovies", ratedMovie);
        return "movies";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Movie theMovie = new Movie();

        theModel.addAttribute("movie", theMovie);
        return "addMovie";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("movieId") Long theId, Model theModel) {
        Movie theMovie = movieService.findById(theId);
        theModel.addAttribute("movie", theMovie);
        return "addMovie";
    }

    @PostMapping("/save")

    //Like SDA
//    public String saveMovie(Model model, Movie movie, BindingResult result) {
//        if (result.hasErrors()) {
//            return "addMovie";
//        }
//        movieRepository.save(movie);
//        return "redirect:movies";

    // Like me
    public String saveMovie(@ModelAttribute("movie") Movie theMovie) {

        //save the movie
        movieService.save(theMovie);

        //use a redirect to prevent duplicate submissions
        return "redirect:/movies";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("movieId") Long theId) {
        movieService.delete(theId);
        return "redirect:/movies";
    }
}
