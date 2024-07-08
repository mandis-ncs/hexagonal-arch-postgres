package com.mandis.hexagonal_architecture.adpters.out.postgreeJDBC;

import com.mandis.hexagonal_architecture.adpters.out.postgreeJDBC.entities.MovieEntity;
import com.mandis.hexagonal_architecture.adpters.out.postgreeJDBC.repositories.MoviesRepository;
import com.mandis.hexagonal_architecture.application.dao.MovieDAO;
import com.mandis.hexagonal_architecture.application.dto.NewMovieDto;
import com.mandis.hexagonal_architecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MoviesDaoAdapter implements MovieDAO {

    private final MoviesRepository moviesRepository;

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findMovieByTitle(title);
    }

    @Override
    public List<Movie> findAllMovies() {
        return ((List<MovieEntity>) moviesRepository.findAll())
                .stream()
                .map(movieEntity -> {
                    return new Movie(
                            movieEntity.id(),
                            movieEntity.title(),
                            movieEntity.description(),
                            movieEntity.releaseDate(),
                            movieEntity.directorName()
                    );
                }).toList();
    }

    @Override
    public void saveMovie(NewMovieDto movieDto) {
        moviesRepository.save(new MovieEntity(
                null, //auto generated
                movieDto.title(),
                movieDto.description(),
                movieDto.releaseDate(),
                movieDto.directorName(),
                null
        ));

    }

    @Override
    public void updateMovie(Movie newMovie) {
        moviesRepository.save(new MovieEntity(
                newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        ));
    }

    @Override
    public void deleteMovie(Movie oldMovie) {
        return;
    }
}
