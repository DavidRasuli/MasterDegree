package rasoly.hw1.movielist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rasoly.hw1.movielist.Service.MovieService.MovieService;
import rasoly.hw1.movielist.model.Movie;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieListController{
    @Autowired
    private MovieService movieService;

    /*
     *  HTTP Get - list of movie by author
     */
    @RequestMapping(value = "/attributes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movie>> getMoviesByViewer(@RequestParam (value = "viewer", required = true) String viewer) {
        List<Movie> movies = movieService.findByViewer(viewer);
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    /*
     * HTTP POST - new movie
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewMovie(@RequestHeader Movie movie) {
        System.out.println("Creating movie with the following details: " + movie);

        return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
    }

}