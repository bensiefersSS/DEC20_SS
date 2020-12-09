package com.ss.basics.add;
/*
*   Author: Ben Siefers
*   Date: 12/8/20
*/
public class Add {
    public static void main(String[] args){
        //return if no args provided
        if(args.length == 0){
            System.out.println("No arguments given!");
            return;
        }
        //check for strings to infer the meaning of "add"
        for(int i=0; i<args.length; i++){
            if(!isNumeric(args[i])){
                buildString(args);
                return;
            }
        }
        //doubles allow for a less verbose infering
        buildDouble(args);
    }

    //Add all the string values
    public static void buildString(String[] strings){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<strings.length; i++)
            sb.append(strings[i]);
        System.out.println(sb);
    }

    //Add all the numeric values
    public static void buildDouble(String[] strings){
        double answer = 0;
        for(int i=0; i<strings.length; i++){
            answer += Double.parseDouble(strings[i]);
        }
        System.out.println(answer);
    }

    //check if strings are able to be translated to doubles
    public static boolean isNumeric(String strNum){
        if(strNum == null)
            return false;
        try{
            double d = Double.parseDouble(strNum);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
