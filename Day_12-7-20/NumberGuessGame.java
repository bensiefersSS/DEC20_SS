import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.abs;

/*
    Author: Ben Siefers
    Date: 12/7/2020
 */
public class NumberGuessGame {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int guessesLeft = 5;
        Random r = new Random();
        //Picks a random number between 1-100.
        int answer = r.nextInt(100) + 1;
        System.out.println("Enter a number between 1 and 100: ");
        //Keeps asking for guesses while guesses are left.
        while(guessesLeft-- != 0){

            //Validate Input by check for Int type and a number between 1-100
            boolean validInput = false;
            int guess = 0;
            while(!validInput) {
                //Checks for non-integers.
                if (!scanner.hasNextInt()){
                    scanner.next();
                    System.out.println("Invalid input please enter an integer:");
                    continue;
                }

                guess = scanner.nextInt();
                //Ensures only numbers between 1-100 are guessed.
                validInput = guess >= 1 && guess <= 100;
                if(!validInput)
                    System.out.println("Invalid number enter a number between 1 and 100: ");
            }
            //Check if they guessed correctly.
            if(answer == guess){
                System.out.println("You guess the number correctly!");
                return;
            //Check if number is within 10 if true then end game.
            }else if(abs(guess - answer) <= 10){
                System.out.println("Sorry " + answer);
                return;
            //Out of range of 10 continue with 1 less guess.
            }else{
                System.out.println("You guess the number incorrectly! ");
                System.out.println("You have " + guessesLeft + " guesses left. Try again:");
            }
        }

    }
}
