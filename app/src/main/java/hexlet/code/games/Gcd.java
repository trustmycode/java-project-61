package hexlet.code.games;

import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.Engine.searchDivisors;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Gcd {

    public static void gcdGame() throws IOException {

        playerGreetings();

        System.out.println("Find the greatest common divisor of given numbers.");
        int correctAnswer;
        Scanner scanner = new Scanner(System.in);
        final int numOfRounds = 3;
        final int rangeOfSelectionOfNumbers = 100;
        for (int i = 0; i < numOfRounds; i++) {
            int firstNum = (int) (Math.random() * rangeOfSelectionOfNumbers);
            int secondNum = (int) (Math.random() * rangeOfSelectionOfNumbers);
            int[] firstDivisors = searchDivisors(firstNum, firstNum / 2 + 1);
            int[] secondDivisors = searchDivisors(secondNum, secondNum / 2 + 1);
            System.out.println("Question: " + firstNum + " " + secondNum);
            System.out.print("Your answer: ");

            String answerString = scanner.next();
            int playerAnswer;

            if (firstNum % secondNum == 0) {
                correctAnswer = secondNum;

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
            } else if (secondNum % firstNum == 0) {
                correctAnswer = firstNum;

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
            } else {
                correctAnswer = gdc(firstDivisors, secondDivisors);

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
            }
            if (i == numOfRounds - 1) {
                congratulationsMessage();
            }
        }
    }

    private static int gdc(int[] firstArray, int[] secondArray) {
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;
        int[] commonDivisors = new int[Math.max(firstArrayLength, secondArrayLength)];
        int commonDivisorsLength = commonDivisors.length;
        int k = 0;
        int gdc = 1;
        for (int firstArrayValue : firstArray) {
            for (int secondArrayValue : secondArray) {
                if (firstArrayValue == secondArrayValue) {
                    commonDivisors[k] = firstArrayValue;
                    k++;
                }
            }
        }
        commonDivisors = Arrays.copyOf(commonDivisors, k);
        for (int i = 0; i < commonDivisorsLength; i++) {
            gdc = commonDivisors[k - 1];
        }
        return gdc;
    }
}
