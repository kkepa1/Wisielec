package wisielec.passwords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordsDaoDbImpl {


    public String getPasswordsFromDb() {

        StringBuilder content = new StringBuilder();

        String selectSQL = "SELECT password FROM sql_hangman.passwords";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            // this is used when in query are placeholders (?) like "SELECT * FROM users WHERE login = ? AND age > ?"
            //preparedStatement.setString(1, userLogin);
            //preparedStatement.setInt(2, age=20);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String pwd = rs.getString("password");

                content.append(pwd);
                content.append(System.lineSeparator());
            }

            return content.toString();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


    public void saveNewPassword(String password) {
        String selectSQL = "INSERT INTO passwords (password) VALUE (?)";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, password);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
