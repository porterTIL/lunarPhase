package com.spaceforce.util.ui;

import com.spaceforce.game.Game;
import com.spaceforce.obj.Interaction;
import com.spaceforce.obj.Item;
import com.spaceforce.obj.Location;
import com.spaceforce.player.Player;
import com.spaceforce.util.fileParsing.GameMap;

import java.util.Scanner;

public class UserInterface {

    private UserInterface() {
    }

    // consider System.console().readLine() to take user input - it doesn't echo the input which may be good for style's sake
    static Scanner userInput = new Scanner(System.in);

    public boolean specialUse(Item item) {
        switch (item.name) {
            case "Garbage":
        }
        return false;
    }

    public static void beginInput() {
        while (true) {
            String userRequest = userInput.next().toUpperCase(); // in what case can userRequest be null? what happens if it's an empty string?

            switch (userRequest) {
                case "HELP":
                    Game.help();
                    break;
                case "SAVE":
                    Game.save();
                    break;
                case "INVENTORY":
                    View.renderText(Player.getInventory().toString());
                    break;
                case "EXIT": {
                    Game.exit();
                    return; // if the switch doesn't have a return somewhere the ide complains, probably because of the infinite loop.
                }
                default: {
                    userRequest = CommandParser.parse(userRequest);
                    Interaction requestTarget = null;
                    String requestAction = null;
                    if (CommandParser.getTarget(userRequest) != null) {
                        requestTarget = CommandParser.getTarget(userRequest);
                    }
                    if (CommandParser.getAction(userRequest) != null) {
                        requestAction = CommandParser.getAction(userRequest);
                    }
                    if (requestAction != null && requestTarget != null) {
                        if (requestAction.equals("PICKUP") && requestTarget.isGrabbable()) {
//                        GameMap.currentLocation.items
                            Game.grabItem((Item) requestTarget);
                        }
                        if (requestAction.equals("DROP") && Player.checkInventory((Item) requestTarget)) {
                            Player.removeItem((Item) requestTarget);
                        }
                        if (requestAction.equals("GO") && GameMap.currentLocation.checkExit(((Location) requestTarget).name)) {
                            GameMap.currentLocation = (Location) requestTarget;
                        }
                        if (requestAction.equals("USE")) {

                        } else {
                            requestTarget.interact(requestAction);
                        }
                    } else {
                        System.out.println(requestAction);
                        System.out.println(requestTarget);
                        View.renderText("Action cannot be completed");
                        Game.help();
                    }
                }
            }
        }
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