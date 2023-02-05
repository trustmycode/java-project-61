package hexlet.code.games;

import java.io.BufferedReader;
import java.io.IOException;

import static hexlet.code.Engine.correctAnswerMessage;
import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.congratulationsMessage;


public class Even {

    public static void evenGame(BufferedReader bufferedReader) throws IOException {
        playerGreetings(bufferedReader);

        int randomNum;
        String answerYes = "yes";
        String answerNo = "no";

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 1; i < 4; i++) {
            randomNum = (int) (Math.random() * 100);

            System.out.println("Question: " + randomNum);
            System.out.print("Your answer: ");

            String playerAnswer = bufferedReader.readLine();

            if (randomNum % 2 == 0) {
                if (playerAnswer.equalsIgnoreCase(answerNo)) {
                    correctAnswerMessage();
                } else {
                    incorrectAnswerMessage(answerNo, playerAnswer);
                    break;
                }
            } else {
                if (playerAnswer.equalsIgnoreCase(answerYes)) {
                    correctAnswerMessage();

                } else {
                    incorrectAnswerMessage(answerYes, playerAnswer);
                    break;
                }
            }
            if (i == 3) {
                congratulationsMessage();
            }
        }
    }
}