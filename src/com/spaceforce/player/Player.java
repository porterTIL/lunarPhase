package com.spaceforce.player;

import com.spaceforce.obj.Item;
import com.spaceforce.util.ui.View;

import java.util.ArrayList;
import java.util.List;

public final class Player {
    private String name;
    //private com.spaceforce.obj.Item[] inventory = new com.spaceforce.obj.Item[10];
    List<Item> inventory = new ArrayList<>(10);
    private int health = 10;

    public Player(){}

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public List<Item> getInventory() {
         return inventory;
     }

     public void setInventory(List<Item> inventory) {
         this.inventory = inventory;
     }

     public int getHealth() {
         return health;
     }

     public void setHealth(int health) {
         this.health = health;
     }

     public boolean checkInventory(Item item){
         View.renderText("");
         return true;
     }
     public List<Item> addItem(Item item){
        //item = null;
       // for (int i = 0; i < inventory.size(); i++){
            inventory.add(item);//check if spot is null
        //}
        return inventory;
     }
     public List<Item> removeItem(Item item){
        inventory.remove(item);
         return inventory;//
     }

 }

