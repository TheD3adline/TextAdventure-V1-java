package at.bbrz.uebungen.textadventure;

import java.util.Scanner;

public class UserInput {

    private static final Scanner sc = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
