package com.example.studybuddy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity implements SubjectAdapter.OnNoteListener {
    private MyDatabase myDatabase;
    private FloatingActionButton fab;
    private SubjectAdapter mAdapter;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddSubject.class));
                finish();
            }
        });
        myDatabase = new MyDatabase(this);
        SQLiteDatabase db = myDatabase.getWritableDatabase();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SubjectAdapter(this,myDatabase.getAllItems(),this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(HomeActivity.this,SubjectObj.class);
//       intent.putExtra("Subject", RecyclerView.ViewHolder.getAdapterPosition());
        startActivity(intent);
    }
}
