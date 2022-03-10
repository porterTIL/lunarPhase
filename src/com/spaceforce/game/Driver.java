package com.spaceforce.game;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        System.out.println("Welcome to the game.");
        System.out.println("Press any key to start the game.");
        userInput.nextLine();


        System.out.println("Welcome to spaceport that you called home.... for now.");
        System.out.println("In the middle of the room there is an empty paper coffee cup");
        System.out.println("From here you can go to north, which miiiiight be north.");

        System.out.println(" What would you like to do? Hint: go north maybe");
        System.out.println("To quit type in the letter \"Q\"");
        System.out.print(": ");
        String choice = userInput.nextLine();

        if (choice.equalsIgnoreCase("Q")) {
            System.out.println("Whelp, you jumped into a black hole. Goodbye!");
            System.exit(0);
        } else if (choice.equalsIgnoreCase("y")) {
            System.out.println("You went north!");
            System.out.println("Whoops bad hint. You died!");
            System.out.println("New Hint: I'm an unreliable narrator!");
        }
    }
}
