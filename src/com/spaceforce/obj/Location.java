package com.spaceforce.obj;

import java.io.IOException;
import java.util.Locale;

public class Location {
    public String id;
    public Item[] items;
    public String description;
    Location(){
    }
    //look, take, go
    public void parseCommand(String noun, String verb) {
        switch(verb.toLowerCase()){
            case "go":
                Item item = findItem(noun);
                if (item == null){
                    System.out.println("");
                } else {
                    item.go();
                }
                break;
            case "take":
                Item item = findItem(noun);
                if (item == null){
                    System.out.println("");
                } else {
                    item.take();
                }
                break;
            case "look":
                Item item = findItem(noun);
                if (noun.equalsIgnoreCase().){
                    System.out.println("");
                } else {
                    item.look();
                }
                break;
            default:
                System.out.println("You tried to " + verb + ", but you stopped before you hurt yourself.");
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

