public class Game {

    private Game(){}

    static void displayIntro(){
        // View.renderImg()
    }
    static void newGame(){
//         Map.init();
//         Map.goTo(Map.area1);
//         UserInterface.beginInput();
    }
    static void help(){
        // put these lines of text into a file for game messages
        View.renderText("These are your commands.");
        View.renderText("Talk, Look, Pickup, Go, Use, Drop");
        View.renderText("You can try to scream but no one will hear you.");
        View.renderText("You can combine these verbs with either location, person, or item.");
        View.renderText("Example: Go spaceport");
        View.renderText("To look at current inventory. Type in \"Inventory\"");
    }
    static void save(){
        // View.renderText("Game Saved");
        // write to save file current area, all area objects alive in Map, and current inventory
    }
    static void exit(){
        System.exit(0);
    }
}
