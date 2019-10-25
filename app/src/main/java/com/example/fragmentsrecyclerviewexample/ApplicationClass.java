package com.example.fragmentsrecyclerviewexample;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application //Application class run right at the start even before main activity starts. everything ends right at the end
{

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("Chuck Norris","5464569874321"));
        people.add(new Person("John Rambo","234737623733"));
        people.add(new Person("Nelson Mandela","2342342342342"));

    }
}
