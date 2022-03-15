package com.spaceforce.util.ui;

import com.spaceforce.game.Game;

import java.util.Scanner;

public class UserInterface {

    private UserInterface(){}

    // consider System.console().readLine() to take user input - it doesn't echo the input which may be good for style's sake
    Scanner userInput = new Scanner(System.in);

    void beginInput(){
        while (true){
            String userRequest = userInput.next().toUpperCase(); // in what case can userRequest be null? what happens if it's an empty string?

            switch (userRequest) {
                case "HELP":
                    Game.help();
                    break;

                case "SAVE":
                    Game.save();
                    break;

                case "INVENTORY":
                    View.renderText(Player.getInventory());
                    break;

                case "EXIT":
                    Game.exit();
                    return; // if the switch doesn't have a return somewhere the ide complains, probably because of the infinite loop.

                default:
//                    userRequest = com.spaceforce.util.ui.CommandParser.parse(userRequest);
//                    currentLocal = GameMap.currentLocation;
//                    ActionSubject subject;
//
//                    if (Player.inventory.contains(noun)){
//                            Item subject = Player.inventory.getItem()
//
//                    }
//                     else if (currentLocal.items.contains(subject) || currentLocal.npcs.contains(subject)){
//                            subject = currentLocal.getSubject()
//                      }
//
//                    if (subject.equals(null)){
//                         View.renderText("This subject is not in sight")
//                         continue;
//                    }
//                    else if (verb.equals(pickup) && subject.grabbable){
//                         subject.interact(pickup)
//                         location.remove(subject)
//                         Player.addInventory(subject)
//                         continue
//                    }
//                     else {
//                          noun.interact(verb);
//                     }
            }
        }
    }
}