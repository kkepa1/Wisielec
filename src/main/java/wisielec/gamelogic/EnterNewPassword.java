package wisielec.gamelogic;

import wisielec.passwords.NewPassword;

import java.util.Scanner;

public class EnterNewPassword {

    public static void enterNewPassword() {
        Scanner scan = new Scanner(System.in);
        String new_password = "";
        boolean new_password_check = false;

        while (!new_password_check) {
            System.out.print("Enter new password (should contain only letters and spaces): ");

            new_password = scan.nextLine();
            new_password_check = new_password.matches("^[ A-Za-z]+$");

            if (!new_password_check) {
                System.out.println("Wrong input!\n");
            }
        }

        NewPassword password = new NewPassword(new_password);
    }
}
