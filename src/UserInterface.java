import java.util.Scanner;

public class UserInterface {

    private UserInterface(){}

    // consider System.console().readLine() to take user input - it doesn't echo the input which may be good for style's sake
    Scanner userInput = new Scanner(System.in);

    void beginInput(){
        while (true){
            String userRequest = userInput.next().toUpperCase(); // in what case can userRequest be null? what happens if it's an empty string?

            switch (userRequest){
                case "HELP":
                    Game.help();
                    break;

                case "SAVE":
                    Game.save();
                    break;

                case "INVENTORY":
//                    View.renderText(Player.getInventory());
                    break;

                case "EXIT":
                    Game.exit();
                    return; // if the switch doesn't have a return somewhere the ide complains, probably because of the infinite loop.

                default:
                    userRequest = CommandParser.parse(userRequest);
                    // check for grabbable attribute

                    // -clarifyNoun(String noun):: ask if item is in environment or inventory
                    // if (Map(userRequest)) continue
                    // else if (Player(userRequest)) continue
                    // else View.renderText("Bad request...")
            }
        }
    }
}