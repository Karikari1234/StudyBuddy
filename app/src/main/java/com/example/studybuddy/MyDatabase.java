package com.example.studybuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.example.studybuddy.SubjectTable.*;

import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_ATTENDENCE;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_CREDITS;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_FINALS;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_GPA;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_ID;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_MID;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_NAME;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_Q1;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_Q2;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_Q3;
import static com.example.studybuddy.SubjectTable.SubjectEntries.SUBJECT_Q4;
import static com.example.studybuddy.SubjectTable.SubjectEntries.TABLE_NAME;

public class MyDatabase extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "StudyBuddy.db";

    private static final String CREATE_TABLE = "CREATE TABLE Subjects ("+SUBJECT_ID+" INTEGER  primary key autoincrement,"+SUBJECT_NAME+" VARCHAR(255),"+SUBJECT_CREDITS+" DECIMAL(3,2),"+SUBJECT_ATTENDENCE+" VARCHAR(255),"+SUBJECT_Q1+" INTEGER,"+SUBJECT_Q2+" INTEGER,"+SUBJECT_Q3+" INTEGER,"+SUBJECT_Q4+" INTEGER,"+SUBJECT_MID+" INETEGER,"+SUBJECT_FINALS+" INTEGER,"+SUBJECT_GPA+" DECIMAL(3,2));";
    private static final int version=1;
    public static final String SELECT_ALL = "SELECT * FROM "+TABLE_NAME;
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Toast.makeText(context,"succcess",Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);

        }catch(Exception e){

            Toast.makeText(context,"Error :"+e,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context,"succcess",Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
        catch (Exception e){
            Toast.makeText(context,"error : "+e,Toast.LENGTH_SHORT).show();
        }


    }
    public long insertData(Subject subject){
        MyDatabase mdb = new MyDatabase(context);
        long rowID;
        try (SQLiteDatabase db = this.getWritableDatabase()) {
//            SubjectAdapter subjectAdapter = new SubjectAdapter(context, mdb.getAllItems(), (SubjectAdapter.OnNoteListener) this);
            ContentValues contentValues = new ContentValues();
            contentValues.put(SUBJECT_NAME, subject.getName());
            contentValues.put(SUBJECT_CREDITS, String.valueOf(subject.getCredits()));
            rowID = db.insert(TABLE_NAME, null, contentValues);
        }
        return rowID;
    }
    public Cursor selectData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery(SELECT_ALL,null);
        return cursor;
    }
    public Cursor getAllItems(){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
    }
}
