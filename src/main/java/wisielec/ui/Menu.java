package wisielec.ui;

import java.util.Scanner;

public class Menu {
    private int response;

    protected void start() {
        this.response = question();
    }

    private static int question() {
        Scanner scan = new Scanner(System.in);

        System.out.println("What do you want to do?");
        System.out.println("1. Enter new password");
        System.out.println("2. Play game");
        System.out.print("Enter correct number: ");

        return scan.nextInt();
    }

}
