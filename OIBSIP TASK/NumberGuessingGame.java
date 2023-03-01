import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        
        // Initialize variables
        int totalRounds = 3;
        int maxAttempts = 5;
        int roundNumber = 1;
        int totalScore = 0;
        
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Loop through each round
        while (roundNumber <= totalRounds) {
            
            System.out.println("Round " + roundNumber + " of " + totalRounds);
            
            // Generate a random number between 1 and 100
            Random random = new Random();
            int numberToGuess = random.nextInt(100) + 1;
            
            // Initialize variables for this round
            int userGuess;
            int numberOfGuesses = 0;
            boolean hasWon = false;
            int roundScore = 0;
            
            // Loop until the user guesses the correct number or runs out of attempts
            while (!hasWon && numberOfGuesses < maxAttempts) {
                
                // Prompt the user for their guess
                System.out.print("Guess a number between 1 and 100: ");
                userGuess = scanner.nextInt();
                numberOfGuesses++;
                
                // Check if the user's guess is correct
                if (userGuess == numberToGuess) {
                    roundScore = maxAttempts - numberOfGuesses + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + numberOfGuesses + " guesses. Your score for this round is " + roundScore + ".");
                    hasWon = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Guess again.");
                } else {
                    System.out.println("Too high. Guess again.");
                }
            }
            
            // If the user ran out of attempts, display the correct answer
            if (!hasWon) {
                System.out.println("Sorry, you ran out of attempts. The correct number was " + numberToGuess + ".");
            }
            
            // Increment the round number
            roundNumber++;
        }
        
        
        System.out.println("Your total score for all rounds is " + totalScore + ".");
        
       
        scanner.close();
    }
}
