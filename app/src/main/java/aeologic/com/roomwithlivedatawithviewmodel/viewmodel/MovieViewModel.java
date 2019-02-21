package aeologic.com.roomwithlivedatawithviewmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import aeologic.com.roomwithlivedatawithviewmodel.database.entity.Movie;
import aeologic.com.roomwithlivedatawithviewmodel.repository.MovieRepository;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;
    private LiveData<List<Movie>> allMovies;

    public MovieViewModel(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);
        allMovies = movieRepository.getAllMovies();
    }

    public void insertMovie(Movie movie) {
        movieRepository.insertMovie(movie);
    }

    public void upDateMovie(Movie movie) {
        movieRepository.updateMovie(movie);
    }

    public void deleteMovie(Movie movie) {
        movieRepository.deleteMovie(movie);
    }

}
