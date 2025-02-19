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

        final int numOfRounds = 3;
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
        final int maxLengthOfProgression = 10;
        final int minLengthOfProgression = 5;
        final int randomFactorOfProgressionDifference = 31;
        final int randomFactorOfChooseFirstNum = 101;

        int progressionLength = (int) (
            Math.random() * (maxLengthOfProgression - minLengthOfProgression + 1)
                + minLengthOfProgression);
        int positionOfElement = (int) (Math.random() * progressionLength);

        StringBuilder arithmeticProgression = new StringBuilder(("Question: "));

        int progressionDifference = (int) (Math.random() * randomFactorOfProgressionDifference + 1);
        int firstNum = (int) (Math.random() * randomFactorOfChooseFirstNum);
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
