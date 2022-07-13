package wisielec.ui;

import wisielec.passwords.GetPassword;

public class Paint {
    public static void paint(int numberOfIncorrectGuesses) {
        switch (numberOfIncorrectGuesses) {
            case 1:
                System.out.println("Incorrect! Try again!");
                System.out.println("""
                        |
                        |
                        |
                        |
                        |
                        |_______________________
                       
                        """);
                break;
            case 2:
                System.out.println("Incorrect! Try again!");
                System.out.println("""
                        _____________________
                        |
                        |
                        |
                        |
                        |
                        |_______________________
                        
                        """);
                break;
            case 3:
                System.out.println("Incorrect! Try again!");
                System.out.println("""
                        _____________________
                        |                   |
                        |
                        |
                        |
                        |
                        |_______________________
                        
                        """);
                break;
            case 4:
                System.out.println("Incorrect! Try again!");
                System.out.println("""
                        _____________________
                        |                   |
                        |                   0
                        |
                        |
                        |
                        |_______________________
                        
                        """);
                break;
            case 5:
                System.out.println("Incorrect! Try again!");
                System.out.println("""
                        _____________________
                        |                   |
                        |                   0
                        |                   |
                        |
                        |
                        |_______________________
                        
                        """);
                break;
            case 6:
                System.out.println("Incorrect! Try again!");
                System.out.println("""
                        _____________________
                        |                   |
                        |                   0
                        |                ---|---
                        |
                        |
                        |_______________________
                        
                        """);
                break;
            case 7:
                System.out.println("Incorrect! Try again!");
                System.out.println("""
                        _____________________
                        |                   |
                        |                   0
                        |                ---|---
                        |                   ^
                        |
                        |_______________________
                        
                        """);
                break;
            case 8:
                System.out.println("Incorrect! Try again!");
                System.out.println("""
                        _____________________
                        |                   |
                        |                   0
                        |                ---|---
                        |                   ^
                        |                  /
                        |_______________________
                        
                        """);
                break;
        }
    }

    public static void endGame(String password) {
        System.out.println("Incorrect");
        System.out.println("""
                        _____________________
                        |                   |
                        |                   0
                        |                ---|---
                        |                   ^
                        |                  / \\
                        |_______________________
                        
                        """);
        System.out.println("Sorry, you lost.");
        System.out.println("The stick man is DEAD!");
        System.out.println("The secret word was: " + "\"" + password + "\"");
        System.exit(0);
    }
}
