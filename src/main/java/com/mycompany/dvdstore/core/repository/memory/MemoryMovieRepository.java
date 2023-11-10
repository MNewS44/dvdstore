package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    public List<Movie> movies = new ArrayList<>();

    public void add (Movie movie)
    {
        movies.add(movie);
        System.out.println("Le film " + movie.getTitle()+" a été ajouté");
    }

    @Override
    public List<Movie> list() {
        return movies;
    }

    @Override
    public Movie getById(long id) {
        int i=0;

        for (i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id) {
                return movies.get(i);
            }
        }
        return null;
    }
}
