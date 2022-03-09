package com.spaceforce.obj;

import java.io.IOException;
import java.util.Locale;

public class Location {
    public String name;
    public Item[] items;
    public String description;
    public String introMessage;
    Location(){
    }
    //look, take, go
    public void parseCommand(String verb, String noun) {
        switch(verb.toLowerCase()){
            case "go": {
                Item item = findItem(noun);
                if (item == null) {
                    System.out.println("");
                } else {
                    item.go();
                }
                break;
            }
            case "take": {
                Item item = findItem(noun);
                if (item == null) {
                    System.out.println("");
                } else {
                    item.pickup();
                }
                break;
            }
            case "look": {
                Item item = findItem(noun);
                if (noun.equalsIgnoreCase("north")) {
                    System.out.println("You see an item of some sort");
                } else {
                    item.look();
                }
                break;
            }
            default:
                System.out.println("You tried to " + verb + ", but you stopped before you hurt yourself.");
                break;
        }
    }
    private Item findItem(String noun) {
            for (Item item : items) {
                if(noun.equalsIgnoreCase(item.name)) {
                    return item;
                }

            }
            return null;
        }
}

