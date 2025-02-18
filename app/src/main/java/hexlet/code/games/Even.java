package hexlet.code.games;

import static hexlet.code.Engine.congratulationsMessage;
import static hexlet.code.Engine.incorrectAnswerMessage;
import static hexlet.code.Engine.playerGreetings;

import java.io.IOException;
import java.util.Scanner;


public class Even {

    public static void evenGame() throws IOException {
        playerGreetings();

        int randomNum;
        String answerYes = "yes";
        String answerNo = "no";

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 4; i++) {
            randomNum = (int) (Math.random() * 100);

            System.out.println("Question: " + randomNum);
            System.out.print("Your answer: ");

            String playerAnswer = scanner.next();

            if (randomNum % 2 == 0) {
                if (playerAnswer.equalsIgnoreCase(answerNo)) {
                    System.out.println("Correct!");
                } else {
                    incorrectAnswerMessage(answerNo, playerAnswer);
                    break;
                }
            } else {
                if (playerAnswer.equalsIgnoreCase(answerYes)) {
                    System.out.println("Correct!");
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