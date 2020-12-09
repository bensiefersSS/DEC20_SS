package com.ss.basics.shape;


/*
 *   Author: Ben Siefers
 *   Date: 12/8/20
 */
public class Triangle implements Shape {

    //area of a triangle is (a*b)/2
    public double calculateArea(double width, double height) {
        double answer = (width*height)/2;
        System.out.println(answer);
        return answer;
    }
    //displays a message for the shape
    public void display() {
        System.out.println("This is a triangle");
    }
}
