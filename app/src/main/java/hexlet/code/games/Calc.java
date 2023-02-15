package hexlet.code.games;

import java.io.BufferedReader;
import java.io.IOException;

import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.congratulationsMessage;

public class Calc {

    public static void calcGame(BufferedReader bufferedReader) throws IOException {

        playerGreetings(bufferedReader);

        System.out.println("What is the result of the expression?");

        for (int i = 1; i < 4; i++) {
            int chooseExpression = (int) (Math.random() * 3 + 1);
            int correctAnswer;
            switch (chooseExpression) {
                case (1):
                    correctAnswer = addition();
                    break;
                case (2):
                    correctAnswer = subtraction();
                    break;
                case (3):
                    correctAnswer = multiplication();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + chooseExpression);
            }

            System.out.print("Your answer: ");

            String answerString = bufferedReader.readLine().trim();
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