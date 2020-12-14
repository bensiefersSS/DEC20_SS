package com.ss.basics.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

interface Function2<One, Two, Three> {
    public Three apply(One one, Two two);
}
interface Function3<One, Two, Three, Four> {
    public Four apply(One one, int i, Two two);
}

public class FunctionalLambdas {

    public static void main(String[] args){
        System.out.println("---isOdd---");
        System.out.println(isOdd().apply(3));
        System.out.println("---isPrime---");
        System.out.println(isPrime().apply(3));
        System.out.println("---isPalindrome---");
        System.out.println(isPalindrome().apply("madam"));
        System.out.println(isPalindrome().apply("madam1"));
        System.out.println("---Remove most right---");
        Integer[] data = {10, 12, 23};
        Arrays.stream(getRightMost().apply(data)).forEach(value -> {
            System.out.println(value);
        });
        System.out.println("---x2---");
        Arrays.stream(multiplyBy2().apply(data)).forEach(value -> {
            System.out.println(value);
        });
        System.out.println("---Remove X---");
        String[] words = {"test", "xtest", "xylophone"};
        Arrays.stream(removeX().apply(words)).forEach(value -> {
            System.out.println(value);
        });

        System.out.println("---Exists Sub-Array Sum---");
        Integer[] subarraySum1 = {2, 4, 8};
        Integer[] subarraySum2 = {1, 2, 4, 8, 1};
        Integer[] subarraySum3 = {2, 4, 4, 8};
        System.out.println(existsSubArraySum().apply(subarraySum1, 10));
        System.out.println(existsSubArraySum().apply(subarraySum2, 14));
        System.out.println(existsSubArraySum().apply(subarraySum3, 14));
    }


    public static Function<Integer, Boolean> isOdd(){
        return (value) -> value % 2 != 0;
    }

    public static Function<Integer, Boolean> isPrime(){
        return (value) -> {
            if(value <= 3){
                return value > 1;
            }
            if(value % 2 == 0 || value % 3 == 0){
                return false;
            }
            int i = 5;
            while(Math.pow(i, 2) <= value){
                if(value % i == 0 || value % (i+2) == 0)
                    return false;
                i += 6;
            }
            return true;
        };
    }

    public static Function<String, Boolean> isPalindrome(){
        return (value) -> {
            StringBuffer sb = new StringBuffer();
            for(int i=value.length()-1; i >= 0; i--){
                sb.append(value.charAt(i));
            }
            return sb.toString().equals(value);
        };
    }

    public static Function<Integer[], Integer[]> getRightMost(){
        return (values) -> {
            return Arrays.stream(values).map(value -> value % 10).toArray(Integer[]::new);

        };
    }

    public static Function<Integer[], Integer[]> multiplyBy2(){
        return (values) -> {
            return Arrays.stream(values).map(value -> value * 2).toArray(Integer[]::new);
        };
    }

    public static Function<String[], String[]> removeX(){
       return (values) -> {
           return Arrays.stream(values).map(value -> value.replace("x","")).toArray(String[]::new);
       };
    }

    public static Function2<Integer[], Integer, Boolean> existsSubArraySum(){
        return (values, target) ->{
            int lastValue = 0;
            int sum = 0;
            //flag to indicate to whether to add the previous value
            boolean adjacentValues = false;
            ArrayList<Integer> remainingSet = new ArrayList<>();

            //get sum of required adjacent values
            for(int i=0; i < values.length; i++){
                if(lastValue != 0 && lastValue == values[i]){
                    //adjust for the newly found subset of identical values
                    if(!adjacentValues){
                        //add previous and new value to sum
                        sum += values[i]*2;
                        //flag that we adjusted for the subset
                        adjacentValues = true;
                        //remove used value from possible values to reach sum
                        remainingSet.remove(remainingSet.size()-1);
                    }else{
                        //use in sum
                        sum += values[i];
                    }
                }else{
                    adjacentValues = false;
                    //not used so add to possible values to reach sum
                    remainingSet.add(values[i]);
                }
                lastValue = values[i];
            }
            //if required sum is greater than target then is it impossible to get target
            if(sum > target)
                return false;
            //found target
            else if(sum == target)
                return true;
            //keep searching
            else
                return existsSubArraySumHelper().apply(remainingSet, target-sum, remainingSet.size());
        };
    }


    //bulk of the subset sum problem
    public static Function3<ArrayList<Integer>, Integer, Integer, Boolean> existsSubArraySumHelper(){
        return (values, target, n) -> {
            //target matched
            if(target == 0)
                return true;
            //no more values left and target hasn't match
            if(n == 0)
                return false;

            //skip if current passes the target
            if(values.get(n-1) > target)
                return existsSubArraySumHelper().apply(values, target, n-1);

            //try both with and without current index
            return existsSubArraySumHelper().apply(values, target, n-1) ||
                   existsSubArraySumHelper().apply(values, target-values.get(n-1), n-1);
        };
    }
}
