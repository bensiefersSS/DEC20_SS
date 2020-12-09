package com.ss.basics.findMax;

import java.util.Arrays;
/*
 *   Author: Ben Siefers
 *   Date: 12/8/20
 */
public class FindMax {
    public static void main(String[] args){
        int[] numbers = {176523, 23454, 2374, 23984, 987743, 90456, 234, 0, -12};
        //keeps track of max and its index
        int max = numbers[0];
        int index = 0;

        //iterate over the list if a larger number is found replace max and index
        for(int i=0; i<numbers.length; i++){
            if(max < numbers[i]){
                max = numbers[i];
                index = i;
            }
        }
        System.out.println("Max: " + max + " Index: " + index);
    }

}
