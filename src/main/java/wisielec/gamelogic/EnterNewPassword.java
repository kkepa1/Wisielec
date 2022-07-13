package wisielec.gamelogic;

import wisielec.passwords.NewPassword;

import java.util.Scanner;

public class EnterNewPassword {

    public void enterNewPassword() {
        Scanner scan = new Scanner(System.in);
        String new_password = "";
        boolean new_password_check = false;

        // input nowego hasla, ktory sklada sie tylko z liter i spacji
        while (!new_password_check) {
            System.out.print("Enter new password (should contain only letters and spaces): ");

            new_password = scan.nextLine();
            new_password_check = new_password.matches("^[ A-Za-z]+$");

            if (!new_password_check) {
                System.out.println("Wrong input!\n");
            }
        }

        // przekazanie hasla do klasy NewPassword
        NewPassword password = new NewPassword(new_password);
    }
}
