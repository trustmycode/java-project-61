package hexlet.code.games;

import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.playerGreetings;

import java.io.IOException;
import java.util.Scanner;

public class Progression {

    private static int correctAnswer;

    public static void progressionGame() throws IOException {

        playerGreetings();

        System.out.println("What number is missing in the progression?");
        Scanner scanner = new Scanner(System.in);

        int numOfRounds = 3;
        for (int i = 0; i < numOfRounds; i++) {
            question();

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

    private static void question() {
        int rightBoard = 10;
        int leftBoard = 5;
        int randomFactor = 31;
        int progressionLength = (int) (Math.random() * (rightBoard - leftBoard + 1) + leftBoard);
        int positionOfElement = (int) (Math.random() * progressionLength);
        StringBuilder arithmeticProgression = new StringBuilder(("Question: "));
        int progressionDifference = (int) (Math.random() * randomFactor + 1);
        int firstNum = (int) (Math.random() * 101);
        for (int i = 0; i < progressionLength; i++) {
            if (i != positionOfElement) {
                arithmeticProgression.append(firstNum).append(" ");
            } else {
                arithmeticProgression.append(".. ");
                correctAnswer = firstNum;
            }
            firstNum += progressionDifference;
        }
        System.out.println(arithmeticProgression.toString().trim());
    }
}
