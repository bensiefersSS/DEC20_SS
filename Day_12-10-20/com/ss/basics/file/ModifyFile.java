package com.ss.basics.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
* Author: Ben Siefers
* Date: 12/11/20
* */
public class ModifyFile {
    public static void main(String[] args){
        //used to test the function path may vary for you
        System.out.println(getFilesInDirectory("./src/com/ss/basics/file"));
        appendText("./src/com/ss/basics/file/lettercount.txt", "appended text\n");
        System.out.println(letterCount("./src/com/ss/basics/file/lettercount.txt"));
    }
    

    //gets names of all files and folders in a directory
    public static List<String> getFilesInDirectory(String path){
        List<String> filesInDir = new ArrayList<>();
        File[] files = new File(path).listFiles();
        if(files == null) return filesInDir;
        for(int i = 0; i < files.length; i++)
            filesInDir.add(files[i].getName());
        return filesInDir;
    }
    //appends text to a file
    public static void appendText(String path,String text){
        FileOutputStream fos = null;
        try{
            //append to file
            fos = new FileOutputStream(new File(path), true);
            fos.write(text.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        //close the file
        }finally {
            if(fos != null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //pass a path to a file to count the number of a certain letter
    public static int letterCount(String path){
        //get input from user
        Scanner s = new Scanner(System.in);
        System.out.println("Enter letter:");
        char letter = s.next().charAt(0);

        int count = 0;
        FileInputStream fis = null;

        try {
             fis = new FileInputStream(new File(path));
             int data = fis.read();
             //read byte by byte
             while(data != -1){
                 if(letter == (char)data)
                     count++;
                 data = fis.read();
             }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            //close the file
            if(fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return count;
    }
}
