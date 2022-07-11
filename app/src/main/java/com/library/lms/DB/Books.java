package com.library.lms.DB;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Books {
    @PrimaryKey
    public long isbn;

    @ColumnInfo
    public String title;
    @ColumnInfo
    public String author;
    @ColumnInfo(name = "total")
    public int total;
    @ColumnInfo(name = "available")
    public int available;

    public Books(long isbn, String title, String author, int total, int available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.total = total;
        this.available = available;
    }
}