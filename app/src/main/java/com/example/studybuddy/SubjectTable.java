package com.example.studybuddy;

import android.provider.BaseColumns;

public class SubjectTable {
    private SubjectTable() {}

    public static final class SubjectEntries implements BaseColumns{
        public static final String TABLE_NAME = "Subjects";
        public static final String SUBJECT_NAME = "Name";
        public static final String SUBJECT_ATTENDENCE = "ATTENDENCE";
        public static final String SUBJECT_Q1 = "QUIZ_ONE";
        public static final String SUBJECT_Q2 = "QUIZ_TWO";
        public static final String SUBJECT_Q3 = "QUIZ_THREE";
        public static final String SUBJECT_Q4 = "QUIZ_FOUR";
        public static final String SUBJECT_MID = "MID";
        public static final String SUBJECT_FINALS = "FINAL";
        public static final String SUBJECT_ID = "_ID";
        public static final String SUBJECT_CREDITS = "Credits";
        public static final String SUBJECT_GPA = "GPA";

    }
}
