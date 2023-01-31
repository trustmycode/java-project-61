package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static hexlet.code.Cli.playerGreetings;
import static hexlet.code.Game.evenGame;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfGame = Integer.parseInt(bufferedReader.readLine());

        switch (numberOfGame) {
            case (1) -> playerGreetings(bufferedReader);
            case (2) -> evenGame(bufferedReader); default -> {
            }
        }

        bufferedReader.close();
    }
}