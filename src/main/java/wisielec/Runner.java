package wisielec;

import wisielec.gamelogic.Menu;
import wisielec.passwords.PasswordsDaoDbImpl;

public class Runner {
    public static void main(String[] args) {
        // uruchomienie menu (całego programu)
        Menu menu = new Menu();
        menu.start();
    }
}
