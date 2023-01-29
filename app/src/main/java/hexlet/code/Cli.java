package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void playerHello() {
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();

        System.out.println("Hello, " + playerName + "!");

        scanner.close();
    }
}