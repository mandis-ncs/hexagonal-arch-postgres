package com.mandis.hexagonal_architecture.adpters.out.postgreeJDBC.repositories;

import com.mandis.hexagonal_architecture.adpters.out.postgreeJDBC.entities.MovieEntity;
import com.mandis.hexagonal_architecture.domain.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MoviesRepository extends CrudRepository<MovieEntity, Long> {


    @Query("select * from movies where title =:title")
    Optional<Movie> findMovieByTitle(@Param("title") String title);
}
