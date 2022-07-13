package wisielec.gamelogic;

import wisielec.passwords.GetPassword;
import wisielec.ui.Paint;

import java.util.Scanner;

public class PlayGame {

    private static int numberOfIncorrectGuesses = 0;

    public void playGame() {
        GetPassword password = new GetPassword();

        do {
            enterLetter(password);
        } while(!password.signs.matches("^[ A-Za-z]+$"));
    }

    private void enterLetter(GetPassword password) {
        Scanner scan = new Scanner(System.in);
        System.out.println(password.signs);
        String letter = "test";

        System.out.print("Enter a letter: ");
        while (!Character.isLetter(letter.charAt(0)) || letter.length() != 1) {
            letter = scan.nextLine();

            if (!Character.isLetter(letter.charAt(0)) || letter.length() != 1) {
                System.out.print(letter + " is a wrong input! Enter a letter: ");
            }
        }

        if (password.checkLetter(letter.charAt(0))) {
            System.out.println("Correct!");
        } else if (!password.checkLetter(letter.charAt(0))) {
            numberOfIncorrectGuesses++;
            if (numberOfIncorrectGuesses == 9) {
                Paint.endGame(password.revealPassword(numberOfIncorrectGuesses));
            }
            Paint.paint(numberOfIncorrectGuesses);
        }
    }
}
