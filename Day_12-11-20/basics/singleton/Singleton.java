package com.ss.basics.singleton;
/*
 Author: Ben Siefers
 Date: 12/12/2020
 Purpose: Show the singleton design pattern
 */
public class Singleton {
    private Singleton singleton;

    public Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton .class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
