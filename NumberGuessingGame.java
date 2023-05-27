import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int secretNumber = getRandomNumber(1, 100);
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("Welcome to the Number Guessing Game!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!hasWon) {
            System.out.print("Enter your guess: ");
            int guess = readInt(reader);
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts!");
                hasWon = true;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private static int readInt(BufferedReader reader) {
        try {
            String input = reader.readLine();
            return Integer.parseInt(input);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return readInt(reader);
        }
    }
}
