package rasoly.hw1.movielist.Service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import rasoly.hw1.movielist.model.Movie;
import rasoly.hw1.movielist.repository.MovieListRepository;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieListRepository movieListRepository;

    @Override
    public List<Movie> findByViewer(String viewer) {
        return movieListRepository.findByViewerIgnoreCase(StringUtils.trimWhitespace(viewer));
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieListRepository.save(movie);
    }
}
