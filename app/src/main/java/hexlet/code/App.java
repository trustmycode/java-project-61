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
        while (true) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - Gcd");
            System.out.println("5 - Progression");
            System.out.println("6 - Prime");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");

            Scanner scanner = new Scanner(System.in);
            int numberOfGame = scanner.nextInt();
            switch (numberOfGame) {
                case (1) -> playerGreetings();
                case (2) -> evenGame();
                case (3) -> calcGame();
                case (4) -> gcdGame();
                case (5) -> progressionGame();
                case (6) -> primeGame();
                case (0) -> System.exit(0);
            }
        }
    }
}