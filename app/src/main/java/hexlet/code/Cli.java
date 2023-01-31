package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void playerGreetings() {
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();

        System.out.println("Hello, " + playerName + "!");

        sc.close();
    }
}