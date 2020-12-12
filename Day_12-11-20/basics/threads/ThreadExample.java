package com.ss.basics.threads;

import java.util.LinkedList;
/*
 Author: Ben Siefers
 Date: 12/12/2020
 Purpose: To show how threads can interact with a single peice of data
 */
public class ThreadExample {
    //Data to consume and produce
    LinkedList<Integer> data = new LinkedList<>();

    //bounds it to a certain size
    int size_cap = 10;

    public  static void main(String[] args){
        ThreadExample te = new ThreadExample();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    te.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    te.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }

    //removes a single piece of data an prints it along with a new size
    public void consume() throws InterruptedException{
        int i = 0;
        while (i++ < 100){
            synchronized(data){
                if(data.size() == 0){
                    //skip this cycle and release lock
                    i--;
                    continue;
                }
                System.out.println("Removed: " + data.pop());
                System.out.println("Current Size: " + data.size());
                //remove to produce non-linear sequencing
                Thread.sleep(500);
            }

        }
    }
    //adds a single piece of data an prints it along with a new size
    public void produce() throws InterruptedException{
        int i = 0;
        while (i++ < 100){
            synchronized(data){
                if(data.size() == size_cap){
                    //skip this cycle and release lock
                    i--;
                    continue;
                }

                data.add(i);
                System.out.println("Added: " + i);
                System.out.println("Current Size: " + data.size());
                //remove to produce non-linear sequencing
                Thread.sleep(500);
            }

        }
    }
}


