package com.example.a6bl4hblu.notes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class addActivity extends AppCompatActivity {

    NoteDatabase db;
    NoteDao dbdao;
    Note n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = NoteDatabase.getDatabase(this);
        dbdao = db.getNoteDao();
    }

    public void confClick(View v) {
        EditText tti = (EditText) findViewById(R.id.titleInput);
        EditText txi = (EditText) findViewById(R.id.textInput);
       // int id = dbdao.getAll().size();
        n = new Note(tti.getText().toString(), txi.getText().toString(), Calendar.getInstance().toString());

        Log.e("baza", "dobavili");
        Thread thr = new Thread(new Runnable() {
            @Override
            public void run() {
                dbdao.insert(n);
            }
        });
        thr.setDaemon(true);
        thr.start();
		
		finish();
    }
}
