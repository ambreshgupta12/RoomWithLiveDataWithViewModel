package aeologic.com.roomwithlivedatawithviewmodel.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import aeologic.com.roomwithlivedatawithviewmodel.database.dao.MovieDao;
import aeologic.com.roomwithlivedatawithviewmodel.database.db.ApplicationDatabase;
import aeologic.com.roomwithlivedatawithviewmodel.database.entity.Movie;

public class MovieRepository {
    private MovieDao movieDao;
    private LiveData<List<Movie>> allMovies;

    public MovieRepository(Application application) {
        movieDao = ApplicationDatabase.getInstance(application).movieDao();
        allMovies = movieDao.getAllMovies();
    }

    public  void insertMovie(Movie movie){
        new InsertMovieAsyncTask(movieDao).execute(movie);
    }

    public  void updateMovie(Movie movie){
        new UpdateMovieAsyncTask(movieDao).execute(movie);
    }
    public  void deleteMovie(Movie movie){
        new DeleteMovieAsyncTask(movieDao).execute(movie);
    }
    public  void deleteAllMovies(Movie movie){
        new DeleteAllMovieAsyncTask(movieDao).execute(movie);
    }

    public  LiveData<List<Movie>> getAllMovies()
    {
        return allMovies;
    }





    private static class InsertMovieAsyncTask extends AsyncTask<Movie, Void, Void> {
        private MovieDao movieDao;

        InsertMovieAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.insertMovie(movies[0]);
            return null;
        }
    }
    private static class UpdateMovieAsyncTask extends AsyncTask<Movie, Void, Void> {
        private MovieDao movieDao;

        UpdateMovieAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.updateMovie(movies[0]);
            return null;
        }
    }
    private static class DeleteMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDao movieDao;

        DeleteMovieAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.deleteMovie(movies[0]);
            return null;
        }
    }
    private static class DeleteAllMovieAsyncTask extends AsyncTask<Movie, Void, Void> {
        private MovieDao movieDao;

        DeleteAllMovieAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.deleteAllMovies();
            return null;
        }
    }


}
