package com.ss.basics.shape;


public class Circle implements Shape {

    //area of a circle is (a*b)*PI
    public double calculateArea(double height, double base) {
        double answer = height*base*Math.PI;
        System.out.println(answer);
        return answer;
    }
    //displays a message for the shape
    public void display() {
        System.out.println("This is a circle");
    }
}