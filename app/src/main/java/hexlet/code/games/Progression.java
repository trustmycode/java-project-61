package hexlet.code.games;

import java.io.BufferedReader;
import java.io.IOException;

import static hexlet.code.Engine.correctAnswerMessage;
import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.congratulationsMessage;

public class Progression {

    static int positionOfElement;

    public static void progressionGame(BufferedReader bufferedReader) throws IOException {

        playerGreetings(bufferedReader);

        System.out.println("What number is missing in the progression?");

        for (int i = 1; i < 4; i++) {
            int[] progressionArray = generateProgressionArray();

            showArray(hideElement(progressionArray));

            int correctAnswer = progressionArray[positionOfElement];

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
                correctAnswerMessage();
            } else {
                incorrectAnswerMessage(correctAnswer, playerAnswer);
                break;
            }
            if (i == 3) {
                congratulationsMessage();
            }
        }
    }

    private static int[] generateProgressionArray() {
        int progressionLength = (int) (Math.random() * (10 - 5 + 1) + 5);
        int[] arithmeticProgression = new int[progressionLength];
        int progressionDifference = (int) (Math.random() * 31);
        for (int i = 0; i < progressionLength; i++) {
            if (i == 0) {
                arithmeticProgression[i] = (int) (Math.random() * 101);
            } else {
                arithmeticProgression[i] = arithmeticProgression[i - 1] + progressionDifference;
            }
        }
        return arithmeticProgression;
    }

    private static String[] hideElement(int[] sourceArray) {
        int sourceArrayLength = sourceArray.length;
        positionOfElement = (int) (Math.random() * sourceArrayLength);
        String[] arrayWithHideElement = new String[sourceArrayLength];
        for (int i = 0; i < sourceArrayLength; i++) {
            if (i != positionOfElement) {
                arrayWithHideElement[i] = String.valueOf(sourceArray[i]);
            } else {
                arrayWithHideElement[i] = "..";
            }
        }
        return arrayWithHideElement;
    }
    private static void showArray(Object[] objects) {
        int objectsLength = objects.length;
        System.out.print("Question: ");
        for (int i = 0; i < objectsLength; i++) {
            if (i != objectsLength - 1) {
                System.out.print(objects[i] + ", ");
            } else {
                System.out.println(objects[i]);
            }
        }
    }
}