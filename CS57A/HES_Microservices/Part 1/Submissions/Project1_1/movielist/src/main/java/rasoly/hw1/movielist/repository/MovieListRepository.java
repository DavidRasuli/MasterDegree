package rasoly.hw1.movielist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rasoly.hw1.movielist.model.Movie;

import java.util.List;

public interface MovieListRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByViewerIgnoreCase(String viewer);
}