package wisielec.ui;

public class Paint {
    // metoda rysujaca wisielca
    public static void paint(int numberOfIncorrectGuesses) {
        System.out.println("\nIncorrect! Try again!");

        switch (numberOfIncorrectGuesses) {
            case 1 -> System.out.println("""
                    |
                    |
                    |
                    |
                    |
                    |_______________________
                                           
                    """);
            case 2 -> System.out.println("""
                    _____________________
                    |
                    |
                    |
                    |
                    |
                    |_______________________
                                            
                    """);
            case 3 -> System.out.println("""
                    _____________________
                    |                   |
                    |
                    |
                    |
                    |
                    |_______________________
                                            
                    """);
            case 4 -> System.out.println("""
                    _____________________
                    |                   |
                    |                   0
                    |
                    |
                    |
                    |_______________________
                                            
                    """);
            case 5 -> System.out.println("""
                    _____________________
                    |                   |
                    |                   0
                    |                   |
                    |
                    |
                    |_______________________
                                            
                    """);
            case 6 -> System.out.println("""
                    _____________________
                    |                   |
                    |                   0
                    |                ---|---
                    |
                    |
                    |_______________________
                                            
                    """);
            case 7 -> System.out.println("""
                    _____________________
                    |                   |
                    |                   0
                    |                ---|---
                    |                   ^
                    |
                    |_______________________
                                            
                    """);
            case 8 -> System.out.println("""
                    _____________________
                    |                   |
                    |                   0
                    |                ---|---
                    |                   ^
                    |                  /
                    |_______________________
                                            
                    """);
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
