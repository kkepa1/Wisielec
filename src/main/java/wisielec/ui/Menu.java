package wisielec.ui;

import wisielec.gamelogic.EnterNewPassword;
import wisielec.gamelogic.PlayGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    /* Dlaczego jezeli daje private static final Scanner scan = new Scanner(System.in);
     * to przy loop skanowanie jest "za wolne" i od razu daje nastepna iteracje
     * ale jak damy scannera do metody to jest git?
     */

    // metoda wybierania dalszej ścieżki programu na podstawie odpowiedzi (wybranej opcji)
    public void start() {
        int response = question();

        while (response == 1) {
            EnterNewPassword enter_new_password = new EnterNewPassword();
            enter_new_password.enterNewPassword();
            response = question();
        }

        if (response == 2) {
            PlayGame play_game = new PlayGame();
            play_game.playGame();
        }
    }
    // metoda generujaca pytanie i zwracajaca odpowiedz
    private int question() {
        Scanner scan = new Scanner(System.in);
        int response = 0;
        boolean response_check = false;

        System.out.println("What do you want to do now?");
        System.out.println("1. Enter new password");
        System.out.println("2. Play game");
        System.out.print("Enter correct number: ");

        while (!response_check) {
            try {
                response = scan.nextInt();
            } catch (InputMismatchException e) {
                String bad_input = scan.next();
                System.out.print(bad_input + " is a wrong input! Enter 1 or 2: ");
                continue;
            }

            response_check = (response == 1) || (response == 2);

            if (!response_check) {
                System.err.print("Wrong number! Enter 1 or 2: ");
            }
        }
        return response;
    }

}
