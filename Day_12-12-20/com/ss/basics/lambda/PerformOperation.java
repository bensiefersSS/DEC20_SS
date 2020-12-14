package com.ss.basics.lambda;

public class PerformOperation {
    public static void main(String[] args){
        String stub = "5\n1 4\n2 5\n3 898\n1 3\n2 12";
        performOperationOnString(stub);
    }

    //takes input and parses the correct response depending upon input
    public static void performOperationOnString(String value){
        String[] opCodes = value.split("\\r?\\n");
        for(int i=1; i <= Integer.parseInt(opCodes[0]); i++){
            int opCode = opCodes[i].charAt(0) - '0';

            String opValue = opCodes[i].split("\\s+")[1];
            if(opCode == 1 ){
                boolean isOdd = FunctionalLambdas.isOdd().apply(Integer.parseInt(opValue));
                if(isOdd)
                    System.out.println("ODD");
                else
                    System.out.println("EVEN");
            }else if(opCode == 2){
                boolean isPrime = FunctionalLambdas.isPrime().apply(Integer.parseInt(opValue));
                if(isPrime)
                    System.out.println("PRIME");
                else
                    System.out.println("COMPOSITE");
            }else if(opCode == 3){
                boolean isPalindrome = FunctionalLambdas.isPalindrome().apply(opValue);
                if(isPalindrome)
                    System.out.println("PALINDROME");
                else
                    System.out.println("NOT PALINDROME");
            }else{
                System.out.println("Invalid Code");
                return;
            }
        }
    }
}
