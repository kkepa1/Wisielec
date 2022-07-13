package wisielec.passwords;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class NewPassword {

    private String password;
    public NewPassword(String password) {
        this.password = password;
        try {
            save(this.password);
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }

    private static void save(String password) throws IOException{
        File file = new File("src/main/java/wisielec/passwords/PasswordBase.txt");
        FileWriter fwriter = new FileWriter(file);
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        bwriter.write(password + "\n");
        bwriter.close();
        System.out.println("Password added to database");
    }
}
