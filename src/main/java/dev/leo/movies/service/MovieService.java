package dev.leo.movies.service;

import dev.leo.movies.model.Movie;
import dev.leo.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Movie createMovie(Movie movie) {
        return repository.save(new Movie(movie.getImdbId(), movie.getTitle(), movie.getReleaseDate(),
                movie.getTrailerLink(), movie.getPoster(), movie.getBackdrops(), movie.getGenres(), movie.getReviews()));
    }

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    public Optional<Movie> findByImdbId(String imdbId) {
        return repository.findByImdbId(imdbId);
    }
}
