package com.mandis.hexagonal_architecture.application.dao;

import com.mandis.hexagonal_architecture.application.dto.NewMovieDto;
import com.mandis.hexagonal_architecture.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    Optional<Movie> findMovieByTitle (String title);

    List<Movie> findAllMovies();

    void saveMovie(NewMovieDto movieDto);

    void updateMovie(Movie newMovie);

    void deleteMovie(Movie oldMovie);
}
