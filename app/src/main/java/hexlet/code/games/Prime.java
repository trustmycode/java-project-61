package hexlet.code.games;

import java.io.BufferedReader;
import java.io.IOException;

import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.searchDivisors;


public class Prime {

    public static void primeGame(BufferedReader bufferedReader) throws IOException {

        playerGreetings(bufferedReader);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String correctAnswer;
        String playerAnswer;

        for (int i = 1; i < 4; i++) {
            int number = (int) (Math.random() * 99 + 2);
            if (isPrime(number)) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            playerAnswer = bufferedReader.readLine();

            if (playerAnswer.trim().equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                incorrectAnswerMessage(correctAnswer, playerAnswer);
                break;
            }
            if (i == 3) {
                congratulationsMessage();
            }
        }
    }

    private static boolean isPrime(int number) {
        if (searchDivisors(number, number / 2 + 1).length == 2) {
            return true;
        }
        return false;
    }
}