package com.ss.basics.shape;
/*
 *   Author: Ben Siefers
 *   Date: 12/8/20
 */
public class Rectangle implements Shape {
    //area of a rectangle is w*h
    public double calculateArea(double width, double height) {
        double answer = width*height;
        System.out.println(answer);
        return answer;
    }
    //displays a message for the shape
    public void display() {
        System.out.println("This is a rectangle");
    }
}
