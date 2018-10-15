package com.example.a6bl4hblu.notes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;



@Entity
public class Note {
    @PrimaryKey @ColumnInfo (name = "_id") int _id;
    @ColumnInfo(name = "title") String title;
    @ColumnInfo(name = "text") String text;
    @ColumnInfo(name = "date") String date;

    Note(int _id, String title, String text, String date) {
        this._id = _id;
        this.title = title;
        this.text = text;
        this.date = date;
    }


    void setId(int s) {
        this._id = s;
    }
    int getId() {
        return this._id;
    }
    void setTitle(String s) {
        this.title = s;
    }
    String getTitle() {
        return this.title;
    }
    void setText(String s) {
        this.text = s;
    }
    String getText() {
        return this.text;
    }
    void setDate(String s) {
        this.date = s;
    }
    String getDate() {
        return this.date;
    }
}