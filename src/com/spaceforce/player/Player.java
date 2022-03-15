package com.spaceforce.player;
import com.spaceforce.obj.Item;
import com.spaceforce.util.ui.View;

import java.util.ArrayList;
import java.util.List;

final public class Player {
    private static String name;
    //private Item[] inventory = new Item[10];
    private static List<Item> inventory = new ArrayList<>(10);
    private static int health = 10;

    public Player(){}

     public static String getName() {
         return name;
     }

     public static void setName(String name) {
         Player.name = name;
     }

     static public List<Item> getInventory() {
         return inventory;
     }

     public static void setInventory(List<Item> inventory) {
         Player.inventory = inventory;
     }

     public static int getHealth() {
         return Player.health;
     }

     public static void setHealth(int health) {
         Player.health = health;
     }

     public static boolean checkInventory(Item item){
         View.renderText("");
         return true;
     }
     public static List<Item> addItem(Item item){
        //item = null;
       // for (int i = 0; i < inventory.size(); i++){
            inventory.add(item);//check if spot is null
        //}
        return inventory;
     }
     public static List<Item> removeItem(Item item){
        inventory.remove(item);
         return inventory;//
     }

 }

