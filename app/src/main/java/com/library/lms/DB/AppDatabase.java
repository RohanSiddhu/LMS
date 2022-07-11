package com.library.lms.DB;

import android.content.Context;
import android.provider.SyncStateContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Books.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BooksDao booksDao();

    private static AppDatabase dataBase;

    public static AppDatabase getInstance(Context context){
        if (null== dataBase){
            dataBase= buildDatabaseInstance(context);
        }
        return dataBase;
    }

    private static AppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "lms.db")
                .allowMainThreadQueries().build();
    }
}
