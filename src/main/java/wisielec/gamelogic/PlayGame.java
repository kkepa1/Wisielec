package wisielec.gamelogic;

import wisielec.passwords.GetPassword;
import wisielec.ui.Paint;

import java.util.Scanner;

public class PlayGame {

    private static int numberOfIncorrectGuesses = 0;

    // wybranie losowego hasla z bazy i iteracje zgadywania (liter lub calego hasla)
    // wygrana - wszystkie puste pola odkryte
    public void playGame() {
        GetPassword password = new GetPassword();

        do {
            enterLetter(password);
        } while(!password.signs.matches("^[ A-Za-z]+$"));
        win(password);
    }

    // metoda zgadywania litery lub calego hasla
    // przegrana - numberOfIncorrectGuesses == 9
    private void enterLetter(GetPassword password) {
        Scanner scan = new Scanner(System.in);
        System.out.println(password.signs);
        String letter;
        boolean loop = true;

        //input litery lub calego hasla
        System.out.print("Enter a letter or whole password: ");
        do {
            letter = scan.nextLine();
            if (letter.matches("^[ A-Za-z]+$")) {
                loop = false;
            } else {
                System.out.print(letter + " is a wrong input! Enter a letter or whole password: ");
            }
        } while(loop);

        //zmienianie stringa na wielkie litery (baza sklada sie z passwordow z wielkich liter)
        letter = letter.toUpperCase();

        //jezeli string jest rowny haslu to uzytkownik wygrywa i koniec programu
        if (letter.equals(password.revealPassword())) {
            win(password);
        }

        //jezeli string jest jedna litera, ktora istnieje w hasle to zmiana pustych pol _ na litere
        //jezeli nic sie nie zgadza to numberOfIncorrectGuesses +1 i nastepny etap wisielca
        if (password.checkLetter(letter.charAt(0)) && letter.length() == 1) {
            password.moveLetter(letter.charAt(0));
            System.out.println("Correct!");
        } else {
            numberOfIncorrectGuesses++;
            if (numberOfIncorrectGuesses == 9) {
                Paint.endGame(password.revealPassword());
            }
            Paint.paint(numberOfIncorrectGuesses);
        }
    }

    // gdy uzytkownik wygra, metoda jest uruchamiana i konczy program
    private static void win(GetPassword password){
        System.out.println("\nCongratulations, you won!");
        System.out.println("You guessed the secret word: " + "\"" + password.revealPassword() + "\"");
        System.out.println("The stick man is alive!");
        System.exit(0);
    }
}
