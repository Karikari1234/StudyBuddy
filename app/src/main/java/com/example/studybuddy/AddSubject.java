package com.example.studybuddy;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddSubject extends AppCompatActivity implements View.OnClickListener {
    private MyDatabase myDatabase;
    private EditText subjectName;
    private Spinner credits;
    private Button addSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        Spinner spinner = (Spinner) findViewById(R.id.credits);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.credit_list, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        myDatabase = new MyDatabase(this);
        SQLiteDatabase db = myDatabase.getWritableDatabase();

        subjectName = (EditText) findViewById(R.id.subject_name);
        credits = (Spinner) findViewById(R.id.credits);
        addSubject =(Button) findViewById(R.id.add_subject);

        addSubject.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = subjectName.getText().toString();
        String creds = credits.getSelectedItem().toString();
        Subject subject = new Subject(name,creds);
        if(v.getId()==R.id.add_subject){
            if(name.trim().length()==0){
                Toast.makeText(getApplicationContext(),"Please Enter Subject Name", Toast.LENGTH_SHORT).show();
                return;
            }
            long ID = myDatabase.insertData(subject);
            subjectName.getText().clear();
            if(ID == -1){
                Toast.makeText(getApplicationContext(),"Cant Insert", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"RowId "+ID+"is inserted",Toast.LENGTH_SHORT).show();
            }
            startActivity(new Intent(AddSubject.this,HomeActivity.class));
            finish();
        }
    }
}
