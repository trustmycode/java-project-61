package hexlet.code;

import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.games.Calc.calcGame;
import static hexlet.code.games.Even.evenGame;
import static hexlet.code.games.Gcd.gcdGame;
import static hexlet.code.games.Prime.primeGame;
import static hexlet.code.games.Progression.progressionGame;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - Gcd");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        Scanner scanner = new Scanner(System.in);
        String numberOfGame = scanner.next();
        System.out.print("Your choice: " + numberOfGame);

        final String greetings = "1";
        final String gameEven = "2";
        final String gameCalc = "3";
        final String gameGcd = "4";
        final String gameProgression = "5";
        final String gamePrime = "6";

        switch (numberOfGame) {
            case greetings -> playerGreetings();
            case gameEven -> evenGame();
            case gameCalc -> calcGame();
            case gameGcd -> gcdGame();
            case gameProgression -> progressionGame();
            case gamePrime -> primeGame();
            default -> System.exit(0);
        }
    }
}
