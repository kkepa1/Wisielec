package wisielec.passwords;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PasswordService {
    private final String random_password;
    public String signs;
    private String[] passwords;
    private PasswordsDaoDbImpl file_handler = new PasswordsDaoDbImpl();

    // wywolanie 3 metod ktore wybieraja losowe haslo z bazy i tworza puste pola _ na podstawie hasla
    public PasswordService() {
        this.passwords = getPasswords().split(System.lineSeparator());
        this.random_password = getRandom();
        this.signs = getSigns();
    }

    // metoda bierze z bazy wszystkie hasla
    private String getPasswords() { return file_handler.getPasswordsFromDb(); }

    // metoda losuje jedno haslo z pobranych z bazy hasel
    private String getRandom() {
        this.passwords = getPasswords().split(System.lineSeparator());
        int idx = new Random().nextInt(this.passwords.length);
        return this.passwords[idx];
    }

    // metoda tworzy puste pola _ na podstawie wylosowanego hasla
    private String getSigns() {
        StringBuilder content = new StringBuilder();
        for (int i=0; i<this.random_password.length(); i++) {
            if (Character.isLetter(this.random_password.charAt(i))) {
                content.append("_");
            }

            if (Character.isWhitespace(this.random_password.charAt(i))) {
                content.append(" ");
            }
        }
        return content.toString();
    }

    // sprawdzenie czy podana litera znajduje sie w hasle
    public boolean checkLetter(char letter) {
        return this.random_password.indexOf(letter) != -1;
    }

    // jezeli litera znajduje sie w hasle to zmiana pustych pol - odkrycie danej litery (lub liter)
    public void moveLetter(char letter) {
        if (checkLetter(letter)) {
            char[] temp = this.signs.toCharArray();

            for (int i=0; i<this.random_password.length(); i++) {
                if (this.random_password.charAt(i) == letter) {
                    temp[i] = letter;
                }
            }
            this.signs = String.valueOf(temp);
        }
    }

    // zwracanie hasla
    public String revealPassword() {
        return this.random_password;
    }

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
        try {
            file_handler.saveNewPassword(new_password.toUpperCase());
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}
