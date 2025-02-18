package hexlet.code;

import static hexlet.code.Engine.playerGreetings;
import static hexlet.code.games.Calc.calcGame;
import static hexlet.code.games.Even.evenGame;
import static hexlet.code.games.Gcd.gcdGame;
import static hexlet.code.games.Prime.primeGame;
import static hexlet.code.games.Progression.progressionGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      int numberOfGame = Integer.parseInt(bufferedReader.readLine());
      switch (numberOfGame) {
        case (1) -> playerGreetings(bufferedReader);
        case (2) -> evenGame(bufferedReader);
        case (3) -> calcGame(bufferedReader);
        case (4) -> gcdGame(bufferedReader);
        case (5) -> progressionGame(bufferedReader);
        case (6) -> primeGame(bufferedReader);
        case (0) -> System.exit(0);
        default -> {
        }
      }
    }
  }
}