package wisielec.passwords;

import java.io.*;

public class FileHandler {

    // napisuje plik (jeżeli go nie ma to tworzy nowy plik). W każdej linijce znajduje sie jedno haslo
    public void save(String password) throws IOException{
        try {
            File file = new File("src/main/resources/PasswordBase.txt");
            if(!file.exists()) {
                try {
                    System.out.println("Creating new file.");
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            FileWriter fwriter = new FileWriter(file, true);
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            bwriter.write(password.toUpperCase() + "\n");
            bwriter.close();
            System.out.println("Password added to database");
        } catch (FileNotFoundException e) {
            System.err.println("File PasswordBase.txt doesn't exist!");
        } catch (IOException e) {
            System.err.println("Something went wrong!");
        }
    }

    public String getPasswordsFromFile() {
        StringBuilder content = new StringBuilder();

        try {
            File file = new File("src/main/resources/PasswordBase.txt");
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
}
