package com.spaceforce.obj;

import java.util.Locale;

public interface Interaction {

    void talk();
    void look();
    void pickup();
    void go();
    void use();
    void drop();
    default void interact(String action){
        switch(action.toUpperCase()){
            case "TALK": this.talk(); break;
            case "LOOK": this.look(); break;
            case "PICKUP": this.pickup(); break;
            case "GO": this.go(); break;
            case "USE": this.use(); break;
            case "DROP": this.drop(); break;
        }
    }
    default boolean isGrabbable(){
        return false;
    }
}