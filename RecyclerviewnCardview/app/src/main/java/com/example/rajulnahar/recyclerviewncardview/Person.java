package com.example.rajulnahar.recyclerviewncardview;

/**
 * Created by Rajul Nahar on 21-May-16.
 */
public class Person {

    private String name;
    private int imageid;

    Person(String name,int id){
        this.name = name;
        this.imageid = id;
    }

    public String getName(){
        return this.name;
    }

    public int getImageid() {
        return this.imageid;
    }
}
