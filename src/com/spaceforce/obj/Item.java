package com.spaceforce.obj;

import com.spaceforce.Interaction;

public class Item implements Interaction {
    public String description;
    public String name;
    @Override
    public void talk() {
        System.out.println("You start to talk to the "+name+" but you start to get weird looks and stop");
    }

    @Override
    public void look() {
        System.out.println(description);
    }

    @Override
    public void pickup() {
        look();
        System.out.println(name+ " was added to your inventory.");
    }

    @Override
    public void go() {
        System.out.println("Time to g-- oh we're here.");
    }

    @Override
    public void use() {
        System.out.println("You're doing something with it, although you're not sure how to describe it.");
    }

    @Override
    public void drop() {
        System.out.println(name + " has stopped weighing you down.");
    }
}
