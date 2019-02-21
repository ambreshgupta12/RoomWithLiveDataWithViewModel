package aeologic.com.roomwithlivedatawithviewmodel.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import aeologic.com.roomwithlivedatawithviewmodel.database.entity.Movie;

public interface MovieDao {
    @Insert
    void insertMovie(Movie movie);

    @Update
    void updateMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);

    @Query("Delete from movie_table")
    void deleteAllMovies();

    @Query("select * from movie_table order by id DESC")
    LiveData<List<Movie>> getAllMovies();


}
