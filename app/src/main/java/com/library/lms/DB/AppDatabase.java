package com.library.lms.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Books.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BooksDao booksDao();
}
