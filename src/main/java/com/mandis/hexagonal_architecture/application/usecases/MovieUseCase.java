package com.mandis.hexagonal_architecture.application.usecases;

import com.mandis.hexagonal_architecture.application.dao.MovieDAO;
import com.mandis.hexagonal_architecture.application.dto.NewMovieDto;
import com.mandis.hexagonal_architecture.domain.Movie;
import com.mandis.hexagonal_architecture.infrastructure.exceptions.MovieAlreadyExistsException;
import com.mandis.hexagonal_architecture.infrastructure.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieUseCase {

    private final MovieDAO movieDAO;

    public String saveMovie(NewMovieDto movieDto) throws MovieAlreadyExistsException {
        //check if the movie is already in DB
        var isPresent = movieDAO.findMovieByTitle(movieDto.title()).isPresent();
        if (isPresent) throw new MovieAlreadyExistsException("Movie already exists");

        //save movie
        movieDAO.saveMovie(movieDto);
        return "Movie saved successfully";
    }

    public List<Movie> getAllMovies() {
        return movieDAO.findAllMovies();
    }

    public String updateMovie(Movie movie) throws MovieNotFoundException {
        //check if the movie is already in DB
        var isPresent = movieDAO.findMovieByTitle(movie.title()).isPresent();
        if (!isPresent) throw new MovieNotFoundException("Movie does not exists");

        movieDAO.updateMovie(movie);
        return "Movie Successfully updated";
    }

    public Movie getMovieByTitle(String movieTitle) {
        return movieDAO.findMovieByTitle(movieTitle).orElseThrow(
                () -> new MovieNotFoundException("Movie does not exists"));
    }

}
