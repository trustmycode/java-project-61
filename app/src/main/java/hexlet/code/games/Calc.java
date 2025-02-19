package hexlet.code.games;

import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.playerGreetings;

import java.io.IOException;
import java.util.Scanner;

public class Calc {

    private static final int RANGE_OF_SELECTION_OF_NUMBERS = 100;
    private static final int NUM_OF_ROUNDS = 3;
    private static final int FACTOR_OF_EXPRESSION = 3;

    public static int getRandomFactor() {
        return RANGE_OF_SELECTION_OF_NUMBERS;
    }

    public static void calcGame() throws IOException {

        playerGreetings();

        System.out.println("What is the result of the expression?");
        Scanner scanner = new Scanner(System.in);

        final int addExpression = 1;
        final int subExpression = 2;
        final int multExpression = 3;
        for (int i = 0; i < NUM_OF_ROUNDS; i++) {
            int chooseExpression = (int) (Math.random() * FACTOR_OF_EXPRESSION + 1);
            int correctAnswer = switch (chooseExpression) {
                case addExpression -> addition();
                case subExpression -> subtraction();
                case multExpression -> multiplication();
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
            if (i == NUM_OF_ROUNDS - 1) {
                congratulationsMessage();
            }
        }
    }

    private static int addition() {
        int firstNum = (int) (Math.random() * RANGE_OF_SELECTION_OF_NUMBERS);
        int secondNum = (int) (Math.random() * RANGE_OF_SELECTION_OF_NUMBERS);
        int sum = firstNum + secondNum;

        System.out.println("Question: " + firstNum + " + " + secondNum);

        return sum;
    }

    private static int subtraction() {
        int firstNum = (int) (Math.random() * RANGE_OF_SELECTION_OF_NUMBERS);
        int secondNum = (int) (Math.random() * RANGE_OF_SELECTION_OF_NUMBERS);
        int diff = firstNum - secondNum;

        System.out.println("Question: " + firstNum + " - " + secondNum);

        return diff;
    }

    private static int multiplication() {
        int firstNum = (int) (Math.random() * RANGE_OF_SELECTION_OF_NUMBERS);
        int secondNum = (int) (Math.random() * RANGE_OF_SELECTION_OF_NUMBERS);
        int prod = firstNum * secondNum;

        System.out.println("Question: " + firstNum + " * " + secondNum);

        return prod;
    }
}
