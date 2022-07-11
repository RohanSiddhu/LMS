package com.library.lms.DB;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BooksDao {
    @Query("SELECT * FROM books")
    List<Books> getAll();

    @Insert
    void insertAll(Books... books);

    @Delete
    void delete(Books book);
}