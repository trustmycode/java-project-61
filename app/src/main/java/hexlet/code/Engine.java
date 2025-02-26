package hexlet.code;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Engine {

    public static String getPlayerName() {
        return playerName;
    }

    private static String playerName;

    public static void playerGreetings() throws IOException {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.next();

        System.out.println("Hello, " + playerName + "!");
    }

    public static void incorrectAnswerMessage(Object correctAnswer, Object playerAnswer) {
        System.out.println("'" + playerAnswer + "' is wrong answer"
            + " ;(. Correct answer was '" + correctAnswer + "'");
        System.out.println("Let's try again, " + playerName + "!");
    }

    public static void congratulationsMessage() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static int[] searchDivisors(int num, int length) {
        int[] divisors = new int[length];
        int k = 0;
        for (int i = 1; i <= length - 1; i++) {
            if (num % i == 0) {
                divisors[k] = i;
                k++;
            }
        }
        divisors[k++] = num;
        divisors = Arrays.copyOf(divisors, k);
        return divisors;
    }
}
