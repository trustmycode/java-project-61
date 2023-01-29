package hexlet.code;

import static hexlet.code.Cli.playerHello;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        playerHello();
    }
}
