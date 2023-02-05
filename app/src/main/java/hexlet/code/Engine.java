package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;

public class Engine {
    public static String playerName;

    public static void playerGreetings(BufferedReader bufferedReader) throws IOException {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        playerName = bufferedReader.readLine();

        System.out.println("Hello, " + playerName + "!");
    }

    public static void correctAnswerMessage() {
        System.out.println("Correct!");
    }

    public static void incorrectAnswerMessage(Object correctAnswer, Object playerAnswer) {
        System.out.println("'" + playerAnswer + "' is wrong answer"
                + " ;(. Correct answer was '" + correctAnswer + "'");
        System.out.println("Let's try again, " + playerName);
    }

    public static void congratulationsMessage() {
        System.out.println("Congratulations, " + playerName);
    }
}
