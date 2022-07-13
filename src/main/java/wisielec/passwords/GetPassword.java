package wisielec.passwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class GetPassword {
    private final String random_password;
    public String signs;
    private String[] passwords;

    // wywolanie 3 metod ktore wybieraja losowe haslo z bazy i tworza puste pola _ na podstawie hasla
    public GetPassword() {
        this.passwords = getPasswords().split(System.lineSeparator());
        this.random_password = getRandom();
        this.signs = getSigns();
    }

    // metoda bierze z bazy wszystkie hasla
    private String getPasswords() {
        StringBuilder content = new StringBuilder();

        try {
            File file = new File("src/main/java/wisielec/passwords/PasswordBase.txt");
            FileReader freader = new FileReader(file);
            BufferedReader breader = new BufferedReader(freader);
            String line;

            while ((line = breader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Database file doesn't exist!");
            e.printStackTrace();
        }

        return content.toString();
    }

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
}
