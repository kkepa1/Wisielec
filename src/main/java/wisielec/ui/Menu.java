package wisielec.ui;

import wisielec.passwords.Password;

import java.util.Scanner;

public class Menu {
    private int response;
    /* Dlaczego jezeli daje private static final Scanner scan = new Scanner(System.in);
     * to przy loop skanowanie jest "za wolne" i od razu daje nastepna iteracje
     * ale jak damy scannera do metody to jest git?
     */

    protected void start() {
        this.response = question();

        if (this.response == 1) {
            enterNewPassword();
        }
        if (this.response == 2) {

        }
    }

    private int question() {
        Scanner scan = new Scanner(System.in);
        int response = 0;
        boolean response_check = false;

        System.out.println("What do you want to do?");
        System.out.println("1. Enter new password");
        System.out.println("2. Play game");
        System.out.print("Enter correct number: ");

        while (!response_check) {
            try {
                response = scan.nextInt();
            } catch (Exception e) {
                String bad_input = scan.next();
                System.err.print(bad_input + " is a wrong input! Enter 1 or 2: ");
                continue;
            }

            response_check = (response == 1) || (response == 2);

            if (!response_check) {
                System.err.print("Wrong number! Enter 1 or 2: ");
            }
        }
        return response;
    }

    private static void enterNewPassword() {
        Scanner scan = new Scanner(System.in);
        String new_password;
        boolean new_password_check = false;

        while (!new_password_check) {
            System.out.print("Enter new password (should contain only letters and spaces): ");

            new_password = scan.nextLine();
            new_password_check = new_password.matches("^[ A-Za-z]+$");

            if (!new_password_check) {
                System.out.println("Wrong input!\n");
            }
        }

        //Password password = new Password();
    }

}
