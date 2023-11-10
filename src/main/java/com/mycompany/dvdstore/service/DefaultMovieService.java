package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
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
}
