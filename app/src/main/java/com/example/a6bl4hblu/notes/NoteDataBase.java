package com.example.a6bl4hblu.notes;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    public abstract NoteDao getNoteDao();

    private static volatile NoteDataBase instance;

    static NoteDataBase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (NoteDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDataBase.class, "note_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
