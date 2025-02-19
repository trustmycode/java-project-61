package hexlet.code.games;

import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.Engine.searchDivisors;

import java.io.IOException;
import java.util.Scanner;


public class Prime {

    public static void primeGame() throws IOException {

        playerGreetings();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String correctAnswer;
        String playerAnswer;
        Scanner scanner = new Scanner(System.in);

        final int numOfRounds = 3;
        final int rangeOfSelectionOfNumber = 99;
        for (int i = 0; i < numOfRounds; i++) {
            int number = (int) (Math.random() * rangeOfSelectionOfNumber + 2);
            if (isPrime(number)) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            playerAnswer = scanner.next();

            if (playerAnswer.trim().equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                incorrectAnswerMessage(correctAnswer, playerAnswer);
                break;
            }
            if (i == numOfRounds - 1) {
                congratulationsMessage();
            }
        }
    }

    private static boolean isPrime(int number) {
        return searchDivisors(number, number / 2 + 1).length == 2;
    }
}
