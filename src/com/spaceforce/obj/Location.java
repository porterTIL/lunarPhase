package com.spaceforce.obj;

import com.spaceforce.NPC;
import com.spaceforce.util.fileParsing.JsonImporter;
import com.spaceforce.util.ui.View;

import java.io.IOException;
import java.util.Map;

public class Location implements Interaction{
    public String name;
    public int[] itemIds;
    public String description = "room";
    public String talkMsg = "You better stop talking to the wall before you get too many weird looks.";
    public String introMsg= "It stinky in here :(";
    public String pickupMsg = "You tried to lift "+name+"but it went as expected";
    public String goMsg = "You're already here";
    public String useMsg = "This isn't a bathroom!";
    public String dropMsg = "Try picking this up before you drop it";
    Map<String, Item> exits; //name of valid locations to move to
    public Item[] items;
    public NPC[] npcs;
    private Location(){}

    //initializes items from id array
    void initItems(){
        if(items == null && itemIds != null){
            items = new Item[itemIds.length];
            try{
                for(int i=0; i < itemIds.length; i++){
                    items[i] = JsonImporter.parseItem(itemIds[i]);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Already initialized");
        }
    }

    //Search items array for matching name
    public Item findItem(String noun) {
        for (Item item : items) {
            if(noun.equalsIgnoreCase(item.name)) {
                return item;
            }
        }
        return null;
    }

    public boolean checkExit(String exit){
        // if the exit provided is an exit for this location && the user has the required item to go there
        if(exits.containsKey(exit) /*&& Player.checkInventory(exits.get(exit)) */) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void talk() {
        View.renderText(talkMsg);
    }

    @Override
    public void look() {
        View.renderText(description);
    }

    @Override
    public void pickup() {
        View.renderText(pickupMsg);
    }

    @Override
    public void go() {
        View.renderText(goMsg);
    }

    @Override
    public void use() {
        View.renderText(useMsg);
    }

    @Override
    public void drop() {
        View.renderText(dropMsg);
    }
}
