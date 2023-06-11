package dev.leo.movies.controller;

import dev.leo.movies.model.Movie;
import dev.leo.movies.repository.MovieRepository;
import dev.leo.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {
    MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(service.findByImdbId(imdbId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody @Validated Movie movie) {
        service.createMovie(movie);
    }

    //Updating movie attributes (ImdbId and reviews stays unchanged)
    @PutMapping(path="/{id}")
    public Movie updateMovieWithPut(@PathVariable(value="id") ObjectId id,
                               @RequestBody @Validated Movie movie) {
        verifyMovie(id);
        Movie updateMovie = verifyMovie(id);
        updateMovie.setTitle(movie.getTitle());
        updateMovie.setReleaseDate(movie.getReleaseDate());
        updateMovie.setTrailerLink(movie.getTrailerLink());
        updateMovie.setPoster(movie.getPoster());
        updateMovie.setBackdrops(movie.getBackdrops());
        updateMovie.setGenres(movie.getGenres());
        return movieRepository.save(updateMovie);
    }

    @DeleteMapping(path= "/{movieId}")
    public void deleteMovie(@PathVariable(value="movieId") ObjectId movieId) {
        verifyMovie(movieId);
        movieRepository.deleteById(movieId);
    }

    private Movie verifyMovie(ObjectId id) throws NoSuchElementException {
        return movieRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Movie doesn't exist for id: " + id));
    }
}
