package wisielec.passwords;

import java.io.*;

public class NewPassword {

    public NewPassword(String password) {
        try {
            save(password);
        } catch (FileNotFoundException e) {
            System.err.println("File PasswordBase.txt doesn't exist!");
        } catch (IOException e) {
            System.err.println("Something went wrong!");
        }
    }

    private static void save(String password) throws IOException{
        File file = new File("src/main/java/wisielec/passwords/PasswordBase.txt");
        FileWriter fwriter = new FileWriter(file, true);
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        bwriter.write(password.toUpperCase() + "\n");
        bwriter.close();
        System.out.println("Password added to database");
    }
}
