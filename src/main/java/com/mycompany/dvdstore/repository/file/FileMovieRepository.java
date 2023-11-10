package com.mycompany.dvdstore.repository.file;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FileMovieRepository implements MovieRepositoryInterface {

    public List<Movie> movies = new ArrayList<>();

    @Value("${movies.file.location}")
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void add (Movie movie)
    {
        FileWriter writer;
        try{
            writer = new FileWriter(file,true);
           // writer=new FileWriter("C:\\tmp\\movies.txt",true);
            writer.write(movie.getTitle()+";"+movie.getGenre()+";\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        movies.add(movie);
        System.out.println("Le film " + movie.getTitle()+" a été ajouté");
    }

    @Override
    public List<Movie> list() {

        List<Movie> movies=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie= new Movie();
                final String[] titreEtGenre = line.split("\\;");
                movie.setTitle(titreEtGenre[0]);
                movie.setGenre(titreEtGenre[1]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
