package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;

public class Cli {
    public static void playerGreetings(BufferedReader bufferedReader) throws IOException {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String playerName = bufferedReader.readLine();

        System.out.println("Hello, " + playerName + "!");

    }
}