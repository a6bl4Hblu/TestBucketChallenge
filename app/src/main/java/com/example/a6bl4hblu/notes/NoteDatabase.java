package com.example.a6bl4hblu.notes;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao getNoteDao();

    private static volatile NoteDatabase instance;

    static NoteDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (NoteDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDatabase.class, "note_database")
                            .build();
                }
            }
        }
        return instance;
    }
}
