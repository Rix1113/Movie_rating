package com.sda.moviedb.service;

import com.sda.moviedb.entity.UserInfoProjection;
import com.sda.moviedb.repository.UserRepository;
import com.sda.moviedb.vo.MovieVo;
import com.sda.moviedb.vo.UserRatingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserRatingVo> getAllUsersWIthMovieRatings() {
        List<UserInfoProjection> usersWithMovieRatings = userRepository.getUsersWithMovieRatings();

        List<UserRatingVo> collect = usersWithMovieRatings.stream().distinct().map(m -> {
            UserRatingVo userRatingVo = new UserRatingVo();
            userRatingVo.setUserName(m.getUserName());
            userRatingVo.setEmail(m.getEmail());

            Set<MovieVo> movieVoSet = new HashSet<>();
            MovieVo movieVo = new MovieVo();
            movieVo.setMovieName(m.getMovieName());
            movieVo.setMovieRating(m.getMovieRating());
            movieVo.setUserRating(m.getUserRating());
            movieVo.setYear(m.getYear());

            movieVoSet.add(movieVo);
            userRatingVo.setMovie(movieVoSet);

            return userRatingVo;
        }).collect(Collectors.toList());

        return collect;
    }
}
