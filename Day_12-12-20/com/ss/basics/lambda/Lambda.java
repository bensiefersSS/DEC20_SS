package com.ss.basics.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args){
        String[] stringData = {"testing", "abc 123", "longest string", "string", "short", "enough", "abc", "adc", "abe", "Abe"};

        sortStrings(stringData);
        reverseSortStrings(stringData);
        alphabeticallySortStrings(stringData);

        sortStringsByE(stringData);
        Arrays.stream(stringData).sorted();
        sortStringsByEWithMethod(stringData);

        int[] intData = {0, 2, -2, -3, -41, 32};
        getCSV(intData);
        getLowerCaseAWith3Chars(stringData);

    }
    //sort strings by length
    public static void sortStrings(String[] data){
        System.out.println("---SORT STRINGS---");
        System.out.println("Before: ");

        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });

        System.out.println();
        System.out.println("After: ");

        Arrays.sort(data, (String a, String b) -> (a.length() - b.length()));
        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });
        System.out.println();

    }
    //sort strings by shortest length
    public static void reverseSortStrings(String[] data){
        System.out.println("---REVERSE SORT STRINGS---");
        System.out.println("Before: ");

        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });

        System.out.println();
        System.out.println("After: ");

        Arrays.sort(data, (String a, String b) -> (b.length() - a.length()));
        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });
        System.out.println();
    }
    //sort strings by first letter
    public static void alphabeticallySortStrings(String[] data){
        System.out.println("---ALPHABETICALLY SORT STRINGS---");
        System.out.println("Before: ");

        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });

        System.out.println();
        System.out.println("After: ");

        Arrays.sort(data, (String a, String b) -> (a.charAt(0) - b.charAt(0)));
        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });
        System.out.println();
    }
    //sort strings if the first character is 'e'
    public static void sortStringsByE(String[] data){
        System.out.println("---E SORT STRINGS---");
        System.out.println("Before: ");

        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });

        System.out.println();
        System.out.println("After: ");

        Arrays.sort(data, (String a, String b) -> a.charAt(0) == 'e' ? -1 : 1);
        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });
        System.out.println();
    }
    //sort strings if the first character is 'e'
    public static void sortStringsByEWithMethod(String[] data){
        System.out.println("---E SORT STRINGS---");
        System.out.println("Before: ");

        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });

        System.out.println();
        System.out.println("After: ");

        Arrays.sort(data, (String a, String b) -> Lambda.isE(a));
        Arrays.stream(data).forEach( string -> {
            System.out.print(string + ", ");
        });
        System.out.println();
    }
    //is first char a 'e'
    public static int isE(String data){
        return data.charAt(0) == 'e' ? -1 : 1;
    }

    //return a CSV string flag with e/o depending on even/oddness
    public static String getCSV(int[] data){
        StringBuffer result = new StringBuffer();
        Arrays.stream(data).forEach(value -> {
            if(value%2 == 0)
                result.append("e" + value + ", ");
            else
                result.append("o" + value + ", ");
        });
        System.out.println("---CSV STRING---");
        System.out.println(result);
        return result.toString();
    }
    //get all 3 sized strings starting with 'a'
    public static String[] getLowerCaseAWith3Chars(String[] data){
        List<String> result = Arrays.stream(data).filter(value -> value.charAt(0) == 'a' && value.length() == 3).collect(Collectors.toList());
        System.out.println("--3 LENGTH AND START WITH 'a'---");
        System.out.println(result);
        return result.toArray(String[]::new);
    }
}
