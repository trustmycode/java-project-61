package hexlet.code.games;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.searchDivisors;


public class Gcd {

    public static void gcdGame(BufferedReader bufferedReader) throws IOException {

        playerGreetings(bufferedReader);

        System.out.println("Find the greatest common divisor of given numbers.");
        int correctAnswer;
        for (int i = 1; i < 4; i++) {
            int firstNum = (int) (Math.random() * 100);
            int secondNum = (int) (Math.random() * 100);
            int[] firstDivisors = searchDivisors(firstNum, firstNum / 2 + 1);
            int[] secondDivisors = searchDivisors(secondNum, secondNum / 2 + 1);
            System.out.println("Question: " + firstNum + " " + secondNum);
            System.out.print("Your answer: ");

            String answerString = bufferedReader.readLine().trim();
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
            if (i == 3) {
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
        for (int i = 0; i < firstArrayLength; i++) {
            for (int j = 0; j < secondArrayLength; j++) {
                if (firstArray[i] == secondArray[j]) {
                    commonDivisors[k] = firstArray[i];
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