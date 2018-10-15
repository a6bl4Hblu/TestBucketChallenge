package com.example.a6bl4hblu.notes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class editActivity extends AppCompatActivity {

    NoteDataBase db;
    NoteDao dbdao;

    EditText tti;
    EditText txi;
    Note edNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        db = NoteDataBase.getDatabase(this);
        dbdao = db.getNoteDao();

        edNote = dbdao.getNote(getIntent().getExtras().getInt("num"));
        tti = (EditText) findViewById(R.id.titleInput);
        txi = (EditText) findViewById(R.id.textInput);

        tti.setText(edNote.title);
        txi.setText(edNote.text);
    }

    public void confClick(View v) {
        edNote.title = tti.getText().toString();
        edNote.text = txi.getText().toString();
        edNote.date = Calendar.getInstance().toString();
        Log.e("baza", "obnovili");
        dbdao.update(edNote);

		finish();
		}
}
