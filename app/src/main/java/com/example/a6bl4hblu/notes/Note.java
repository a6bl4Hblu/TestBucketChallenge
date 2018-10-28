package com.example.a6bl4hblu.notes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;



@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true) @ColumnInfo (name = "_id") int _id;
    @ColumnInfo(name = "title") String title;
    @ColumnInfo(name = "text") String text;
    @ColumnInfo(name = "date") String date;

    Note(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }
}