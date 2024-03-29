package hexlet.code.games;

import java.io.BufferedReader;
import java.io.IOException;

import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.congratulationsMessage;

public class Progression {

    static int positionOfElement;
    static int progressionLength;
    static int correctAnswer;

    public static void progressionGame(BufferedReader bufferedReader) throws IOException {

        playerGreetings(bufferedReader);

        System.out.println("What number is missing in the progression?");

        for (int i = 1; i < 4; i++) {
            question();

            System.out.print("Your answer: ");

            String answerString = bufferedReader.readLine();
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

    private static void question() {
        progressionLength = (int) (Math.random() * (10 - 5 + 1) + 5);
        positionOfElement = (int) (Math.random() * progressionLength);
        String arithmeticProgression = ("Question: ");
        int progressionDifference = (int) (Math.random() * 31 + 1);
        int firstNum = (int) (Math.random() * 101);
        for (int i = 0; i < progressionLength; i++) {
            if (i != positionOfElement) {
                arithmeticProgression += firstNum + " ";
                firstNum += progressionDifference;
            } else {
                arithmeticProgression += ".. ";
                correctAnswer = firstNum;
                firstNum += progressionDifference;
            }
        }
        System.out.println(arithmeticProgression.trim());
    }
}