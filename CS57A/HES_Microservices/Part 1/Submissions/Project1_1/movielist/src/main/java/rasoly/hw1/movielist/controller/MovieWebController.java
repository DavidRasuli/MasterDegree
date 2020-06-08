package rasoly.hw1.movielist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rasoly.hw1.movielist.Service.MovieService.MovieService;
import rasoly.hw1.movielist.model.Movie;

@Controller
@RequestMapping("/movieList")
public class MovieWebController {
    private MovieService movieService;
    private String viewer;

    @Autowired
    public MovieWebController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public String addToMovies(Movie movie) {
        viewer = movie.getViewer();
        movieService.saveMovie(movie);
        return "redirect:/movieList";
    }

    @GetMapping
    public String getMovieByViewer(Model model) {
        List<Movie> movies = movieService.findByViewer(viewer);
        if (movies != null) {
            model.addAttribute("movies", movies);
        }
        return "movieList";
    }
}
