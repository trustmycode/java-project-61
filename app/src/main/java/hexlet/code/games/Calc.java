package hexlet.code.games;

import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.playerGreetings;

import java.io.IOException;
import java.util.Scanner;

public class Calc {

    public static void calcGame() throws IOException {

        playerGreetings();

        System.out.println("What is the result of the expression?");
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i < 4; i++) {
            int chooseExpression = (int) (Math.random() * 3 + 1);
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
            if (i == 3) {
                congratulationsMessage();
            }
        }
    }

    private static int addition() {
        int firstNum = (int) (Math.random() * 100);
        int secondNum = (int) (Math.random() * 100);
        int sum = firstNum + secondNum;

        System.out.println("Question: " + firstNum + " + " + secondNum);

        return sum;
    }

    private static int subtraction() {
        int firstNum = (int) (Math.random() * 100);
        int secondNum = (int) (Math.random() * 100);
        int diff = firstNum - secondNum;

        System.out.println("Question: " + firstNum + " - " + secondNum);

        return diff;
    }

    private static int multiplication() {
        int firstNum = (int) (Math.random() * 100);
        int secondNum = (int) (Math.random() * 100);
        int prod = firstNum * secondNum;

        System.out.println("Question: " + firstNum + " * " + secondNum);

        return prod;
    }
}