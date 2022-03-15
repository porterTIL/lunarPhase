package com.spaceforce.obj;

import com.spaceforce.util.ui.View;

import java.io.File;

public class Item implements Interaction {

    public String lookMsg = "Why you trying to look at that";
    public String talkMsg = "You obviously been in space for too long that you are " +
            "try to speak to an item";
    public String pickMsg = "You have picked up ";
    public String nonpickMsg = "Your pathetic space arms were not able to pick it up";
    public String goMsg = "You try to make it go, but it comes right back";
    public String dropMsg = "You have dropped ";
    public String useMsg = "You have used ";
    public String name = "What's my name?";
    public boolean grabbable;


    public void look() {
        View.renderText(lookMsg);
    }

    public void talk() {
        View.renderText(talkMsg);
    }

    public void pickup() {
        if (grabbable == true) {
            View.renderText(pickMsg + name );
        } else {
            View.renderText(nonpickMsg);
        }
    }

    public void go() { // IN IMPLEMENTATION COMPARE USER INPUT TO REACHABLE LOCATIONS FROM THIS LOCATION
        View.renderText(goMsg);
    }

    public void drop() {
        View.renderText(dropMsg + name);
    }

    public void use() {
        View.renderText(useMsg + name);
    }

}
