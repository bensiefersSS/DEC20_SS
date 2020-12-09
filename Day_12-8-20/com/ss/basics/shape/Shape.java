package com.ss.basics.shape;
/*
 *   Author: Ben Siefers
 *   Date: 12/8/20
 */
public interface Shape {
    //finds the area of the shape
    double calculateArea(double width, double height);
    //sends a message of the chosen shape
    void display();
}
