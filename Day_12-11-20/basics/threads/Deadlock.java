package com.ss.basics.threads;
/*
 Author: Ben Siefers
 Date: 12/12/2020
 Purpose: demonstrate the concept of deadlocking
 */
public class Deadlock {
    //values that allows to lock
    public static Object value1 = new Object();
    public static Object value2 = new Object();

    public static void main(String args[]) {
        processA T1 = new processA();
        processB T2 = new processB();
        T1.start();
        T2.start();
    }
    //process A locks value1 then waits for process B to lock value2
    private static class processA extends Thread {
        public void run(){
            synchronized(value1){
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(value2){}
            }
        }
    }
    //process B locks value2 then waits for process A to lock value1
    private static class processB extends Thread {
        public void run(){
            synchronized(value2){
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(value1){}
            }
        }
    }
}
