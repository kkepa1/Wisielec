package wisielec.ui;

import wisielec.passwords.Password;

import java.util.Scanner;

public class Menu {
    private static final Scanner scan = new Scanner(System.in);
    private int response;

    protected void start() {
        this.response = question();

        checkAnswer(this.response);
    }

    private int question() {
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

    private static void checkAnswer(int response) {
        if (response == 1) {
            //enterNewPassword();
        }
        if (response == 2) {

        }
    }

    /*private static void enterNewPassword() {
        System.out.print("Enter new password: ");

        String newPassword = scan.nextLine();

        Password password = new Password();
    }*/

}
