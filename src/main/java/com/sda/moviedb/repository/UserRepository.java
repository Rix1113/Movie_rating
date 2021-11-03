package com.sda.moviedb.repository;

import com.sda.moviedb.entity.User;
import com.sda.moviedb.entity.UserInfoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select user.name as userName, user.email, um.rating as userRating, m.name as movieName, m.rating as movieRating, m.year from user left join user_movie um on user.id = um.user_id left join movie m on m.id = um.movie_id;", nativeQuery = true)
    List<UserInfoProjection> getUsersWithMovieRatings();
}
