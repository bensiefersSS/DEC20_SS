/*
    Author: Ben Siefers
    Date: 12/7/2020
 */
public class Patterns {
    public static void main(String[] args){

        //pattern 1
        System.out.println("1)");
        for(int i=0; i < 5; i++){
            //For last line of code adds the unique line.
            if(i==4){
                System.out.println(".........");
            }else{
                //iteratively add "*"
                for(int j=0; j <= i; j++)
                    System.out.print("*");
                System.out.print("\n");
            }
        }
        //pattern 2
        System.out.println("2)");
        for(int i=0; i < 5; i++){
            //For first line of code adds the unique line.
            if(i==0){
                System.out.println("..........");
            }else{
                //iteratively add "*"
                for(int j=5; j > i; j--)
                    System.out.print("*");
                //end row
                System.out.print("\n");
            }
        }
        //pattern 3
        System.out.println("3)");
        for(int i=0; i < 5; i++){
            if(i==4){
                System.out.println("...........");
                continue;
            }
            //Pushes the "*" to the center.
            for(int j=0; j < 5 - i; j++)
                System.out.print(" ");
            //Adds the center "*".
            System.out.print("*");
            //Adds any additional "*".
            for(int j=0; j < i; j++)
                System.out.print("**");
            System.out.print("\n");
        }

        //pattern 4
        System.out.println("4)");
        //This is inverse the previous pattern.
        for(int i=4; i >= 0; i--){
            if(i==4){
                System.out.println("............");
                continue;
            }
            //Adds any additional "*".
            for(int j=0; j < 5 - i; j++)
                System.out.print(" ");
            System.out.print("*");
            //Adds any additional "*".
            for(int j=0; j < i; j++)
                System.out.print("**");
            System.out.print("\n");

        }
    }
}
