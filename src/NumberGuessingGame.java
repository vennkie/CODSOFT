import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void play(){
        final int MIN = 1;
        final int MAX = 100;
        final int MAX_TRIES = 10;
        int totalScore = 0;
        Scanner input = new Scanner(System.in);
        Random rng = new Random();
        System.out.println("Welcome to the number guessing game!");

        while (true) {
            int secretNumber = rng.nextInt(1,100);
            int attempts = 0;
            System.out.println("Please guess a number between " + MIN + " and " + MAX + ".");
            System.out.println("Try your luck! You have " + MAX_TRIES + " attempts.");

            while (attempts < MAX_TRIES) {
                System.out.print("Your Guess: ");
                if (!input.hasNextInt()) {
                    System.out.println("That does not seem to be a number. Try again.");
                    input.next();
                    continue;
                }
                int userGuess = input.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Amazing! You guessed it in " + attempts + " tries.");
                    totalScore++;
                    break;
                }

                if (userGuess < secretNumber) {
                    System.out.println("Too low! Give it another shot.");
                } else {
                    System.out.println("Too high! Try a smaller number.");
                }
            }

            if (attempts == MAX_TRIES) {
                System.out.println("You're out of attempts. The number was " + secretNumber + ".");
            }
            System.out.println("Current Score: " + totalScore);
            System.out.print("Want to play again? (yes/no): ");
            String response = input.next().trim().toLowerCase();


            if (!response.equals("yes")) {
                System.out.println("Thanks for playing! Your final score: " + totalScore);
                break;
            }
        }

        input.close();
    }

    public static void main(String[] args) {
        play();
    }
}

