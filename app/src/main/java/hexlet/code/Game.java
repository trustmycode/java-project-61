package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;

import static hexlet.code.Cli.playerGreetings;

public class Game {
    public static void evenGame(BufferedReader bufferedReader) throws IOException {
        String playerName = playerGreetings(bufferedReader);
        int randomNum;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 1; i < 4; i++) {
            randomNum = (int) (Math.random() * 100);

            System.out.println("Question: " + randomNum);
            System.out.print("Your answer: ");

            String playerAnswer = bufferedReader.readLine();

            if (randomNum % 2 == 0 && playerAnswer.equalsIgnoreCase("no")) {
                System.out.println("Correct!");
            } else if (randomNum % 2 != 0 && playerAnswer.equalsIgnoreCase("yes")) {
                System.out.println("Correct!");
            } else if (randomNum % 2 == 0 && playerAnswer.equalsIgnoreCase("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + playerName);
                break;
            } else if (randomNum % 2 != 0 && playerAnswer.equalsIgnoreCase("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                System.out.println("Let's try again, " + playerName);
                break;
            } else {
                System.out.println("'" + playerAnswer + "'" + " is incorrect answer.");
                System.out.println("Let's try again, " + playerName);
                break;
            }
            if (i == 3) {
                System.out.println("Congratulations, " + playerName);
            }
        }
    }
}
