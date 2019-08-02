package com.example.studybuddy;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Subject implements Parcelable {
    private String name;
    private double credits;
    private double q1;
    private double q2;
    private double q3;
    private double q4;
    private double mid;
    private double finals;
    private double gpa;

    public Subject(String name, String credits) {
        this.name = name;
        this.credits = Double.parseDouble(credits);
        q1=0.0;
        q2=0.0;
        q3=0.0;
        q4=0.0;
        mid=0.0;
        finals=0.0;
        gpa=0.0;
    }

    protected Subject(Parcel in) {
        name = in.readString();
        credits = in.readDouble();
        q1 = in.readDouble();
        q2 = in.readDouble();
        q3 = in.readDouble();
        q4 = in.readDouble();
        mid = in.readDouble();
        finals = in.readDouble();
        gpa = in.readDouble();
    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel in) {
            return new Subject(in);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public double getQ1() {
        return q1;
    }

    public void setQ1(double q1) {
        this.q1 = q1;
    }

    public double getQ2() {
        return q2;
    }

    public void setQ2(double q2) {
        this.q2 = q2;
    }

    public double getQ3() {
        return q3;
    }

    public void setQ3(double q3) {
        this.q3 = q3;
    }

    public double getQ4() {
        return q4;
    }

    public void setQ4(double q4) {
        this.q4 = q4;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public double getFinals() {
        return finals;
    }

    public void setFinals(double finals) {
        this.finals = finals;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(credits);
        dest.writeDouble(q1);
        dest.writeDouble(q2);
        dest.writeDouble(q3);
        dest.writeDouble(q4);
        dest.writeDouble(mid);
        dest.writeDouble(finals);
        dest.writeDouble(gpa);
    }
}
