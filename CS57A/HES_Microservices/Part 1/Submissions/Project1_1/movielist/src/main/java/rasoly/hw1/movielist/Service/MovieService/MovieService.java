package rasoly.hw1.movielist.Service.MovieService;

import org.springframework.stereotype.Service;
import rasoly.hw1.movielist.model.Movie;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> findByViewer(String viewer);

    Movie saveMovie(Movie movie);
}
