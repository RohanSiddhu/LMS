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
    @ColumnInfo(name = "total_count")
    public int totalCount;
    @ColumnInfo(name = "available_count")
    public int availableCount;
}