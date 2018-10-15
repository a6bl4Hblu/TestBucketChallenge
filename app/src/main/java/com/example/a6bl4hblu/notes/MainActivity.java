package com.example.a6bl4hblu.notes;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends AppCompatActivity {

    NoteDataBase db;
    NoteDao dbdao;
    SimpleCursorAdapter sc;
    ListView lv;
    Context cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = NoteDataBase.getDatabase(this);
        dbdao = db.getNoteDao();

        lv = (ListView) findViewById(R.id.lv);
        sc = updateDB(this);
        lv.setAdapter(sc);
		cont = this;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(cont, editActivity.class);
                Note n = (Note) lv.getItemAtPosition(position);
                intent.putExtra("num", n._id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);

        sc.notifyDataSetChanged();
        //sc = updateDB(this);
        Log.e("baza", "set odapatr");
        lv.setAdapter(sc);
        //setContentView(R.layout.activity_main);
    }

    public SimpleCursorAdapter updateDB(Context cont) {
        Cursor c = dbdao.getFirstCursor();
        String[] from = { c.getColumnName(1), c.getColumnName(3) };
        int[] to = { R.id.titleList, R.id.dateList };
        return new SimpleCursorAdapter(cont, R.layout.list_net, c, from, to);
    }

    public void addClick(View v) {
        Intent intent = new Intent(this, addActivity.class);
        startActivity(intent);
    }
}