package hexlet.code.games;

import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.playerGreetings;

import java.io.IOException;
import java.util.Scanner;

public class Calc {

    private static final int RANDOM_FACTOR = 100;

    public int getRandomFactor() {
        return RANDOM_FACTOR;
    }
    public static void calcGame() throws IOException {

        playerGreetings();

        System.out.println("What is the result of the expression?");
        Scanner scanner = new Scanner(System.in);

        int numOfRounds = 3;
        int randomFactor = 3;
        for (int i = 0; i < numOfRounds; i++) {
            int chooseExpression = (int) (Math.random() * randomFactor + 1);
            int correctAnswer = switch (chooseExpression) {
                case (1) -> addition();
                case (2) -> subtraction();
                case (3) -> multiplication();
                default -> throw new IllegalStateException("Unexpected value: " + chooseExpression);
            };

            System.out.print("Your answer: ");

            String answerString = scanner.next();
            int playerAnswer;
            try {
                playerAnswer = Integer.parseInt(answerString);
            } catch (NumberFormatException e) {
                incorrectAnswerMessage(correctAnswer, answerString);
                break;
            }

            if (playerAnswer == correctAnswer) {
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

    private static int addition() {
        int firstNum = (int) (Math.random() * RANDOM_FACTOR);
        int secondNum = (int) (Math.random() * RANDOM_FACTOR);
        int sum = firstNum + secondNum;

        System.out.println("Question: " + firstNum + " + " + secondNum);

        return sum;
    }

    private static int subtraction() {
        int firstNum = (int) (Math.random() * RANDOM_FACTOR);
        int secondNum = (int) (Math.random() * RANDOM_FACTOR);
        int diff = firstNum - secondNum;

        System.out.println("Question: " + firstNum + " - " + secondNum);

        return diff;
    }

    private static int multiplication() {
        int firstNum = (int) (Math.random() * RANDOM_FACTOR);
        int secondNum = (int) (Math.random() * RANDOM_FACTOR);
        int prod = firstNum * secondNum;

        System.out.println("Question: " + firstNum + " * " + secondNum);

        return prod;
    }
}
