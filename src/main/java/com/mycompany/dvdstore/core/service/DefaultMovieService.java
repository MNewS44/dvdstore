package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface{
    public DefaultMovieService(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepositoryInterface movieRepository;

    public void registerMovie(Movie movie)
    {
        movieRepository.add(movie);
    };

    @Override
    public List<Movie> getMovieList() {
        return movieRepository.list();
    }

    @Override
    public Movie getMovieById(long id) {
        return movieRepository.getById(id);
    }
}
