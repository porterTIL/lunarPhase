package com.spaceforce;

public interface Interaction {

    default void interact(String action) {
        switch (action.toUpperCase()) {
            case "TALK":
                this.talk();
            case "LOOK":
                this.look();
            case "PICKUP":
                this.pickup();
            case "GO":
                this.go();
            case "USE":
                this.use();
            case "DROP":
                this.drop();
        }
    }
    void talk();
    void look();
    void pickup();
    void go();
    void use();
    void drop();
}