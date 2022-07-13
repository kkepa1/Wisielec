package wisielec.passwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class GetPassword {
    private String random_password;
    public String signs;
    private String[] passwords;
    private char[] check_letters = {};

    public GetPassword() {
        this.passwords = getPasswords().split(System.lineSeparator());
        this.random_password = getRandom();
        this.signs = getSigns();
    }

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
            e.printStackTrace();
        }

        return content.toString();
    }

    private String getRandom() {
        this.passwords = getPasswords().split(System.lineSeparator());
        int idx = new Random().nextInt(this.passwords.length);
        return this.passwords[idx];
    }

    private String getSigns() {
        StringBuilder content = new StringBuilder();
        boolean con;
        for (int i=0; i<this.random_password.length(); i++) {
            if (Character.isLetter(this.random_password.charAt(i))) {
                content.append("_");
            }

            if (Character.isWhitespace(this.random_password.charAt(i))) {
                content.append(" ");
            }

            for (int j=0; j<this.check_letters.length; j++) {
                if(this.check_letters[j] == this.random_password.charAt(i)) {

                }
            }
        }
        return content.toString();
    }

    public boolean checkLetter(char letter) {
        if (this.random_password.indexOf(letter) != -1) {
            char[] temp = this.signs.toCharArray();

            for (int i=0; i<this.random_password.length(); i++) {
                if (this.random_password.charAt(i) == letter) {
                    temp[i] = letter;
                }
            }
            this.signs = String.valueOf(temp);
        }
        return this.random_password.indexOf(letter) != -1;
    }
}