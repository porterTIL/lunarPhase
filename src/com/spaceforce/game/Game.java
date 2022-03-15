package com.spaceforce.game;

import com.spaceforce.util.ui.View;

import java.io.File;

public class Game {

    private Game(){}

    static void displayIntro(){
         View.renderImage(new File("Resources/Images/birdLogo.txt"));
    }
    public static void newGame(){
//         Map.init();
//         Map.goTo(Map.area1);
//         com.spaceforce.util.ui.UserInterface.beginInput();
    }
    public static void help(){
        // put these lines of text into a file for game messages
        View.renderText("These are your commands.");
        View.renderText("Talk, Look, Pickup, Go, Use, Drop");
        View.renderText("You can try to scream but no one will hear you.");
        View.renderText("You can combine these verbs with either location, person, or item.");
        View.renderText("Example: Go spaceport");
        View.renderText("To look at current inventory. Type in \"Inventory\"");
    }
    public static void save(){
        // com.spaceforce.util.ui.View.renderText("com.spaceforce.game.Game Saved");
        // write to save file current area, all area objects alive in Map, and current inventory
    }
    public static void exit(){
        System.exit(0);
    }
}
