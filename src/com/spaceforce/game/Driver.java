package com.spaceforce.game;

import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int health = 3;
        String[] inventory = new String[10];
        inventory[0] = "Single Broken Cigarette";
        Scanner userInput = new Scanner(System.in);

        System.out.println("This is a text based adventure where you lost the company spaceship.");
        System.out.println("In order to not lose your job you need to find it before anyone notices it gone!");
        System.out.println("Will you take on the challenge of not getting fired!");
        System.out.println("Press any key to start the game.");
        userInput.nextLine();

        System.out.println("Welcome to the game.");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&@@&&&&&&&&&&&&&&@@&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&###///**///***///((%%%&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&**.,,,,*,,,,.,,,,,*,,,,****,*//(#(#&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&%..,.,,,,...,,,,,,.,...,,,,,,,,,....*(/(##%%&%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&,..,.,........,,,.............,,,,*****,***/((/(#(#(@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&(........... ...... ......,,,,,..,*//////////***//((((#((%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@&&&&&%,.....,...,..........,,,.,,,**,*****////////(((((/**/((((((((((%@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@&&&&%,................,,,,*,**,,,,,,,.,,***///////(///((//(/////(((((((((&@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@&&&&%(.............,.....,**,,,,,,....,.,,...**//*////*///////////////(((//(#@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@&&&&%.................,,,,. ..,,.....,....,,*****//////////////////////////(*/(%@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@&&&%%...................,.,,,......,.*,,,,,,**//**///////*****,,/*///////////****/&@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@&&&#.......... ........,,...,,,,.,,,*******,,,***,**//////****,,,,,,/*////*,,,**,**/&@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@&&&% .........    .....,.*,,.,.,**************,,,*,.,//*,.,,**,**,.,..,,,,******,,**/(&@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@&&&% ..........     ....,,,,..,,,**************,.,,,,,.,.,.,,,...........,*****,**,,,*/%@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@&&&#..........   ...... ...,,,,,,,,************,,,,........ ...,,........,,***,,,,*,****&&&@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@&&%  .,......... .. .....,.,,.,,,,,************,.......... .....,,.... ..,,,,*,,,,*,****,&&@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@&&%.,,,......  .........,,...,....,*,,,,****.........,,*,,,,,...,..........,,.,,,,,***,,,&&&@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@&&%.,,*.,...... ........,,...... ..*,,,,,,*,......,******,*,,,.,,..........,..,,.,.,**,,,&&&&@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@&&&.,,.............................,,,.,*,..,.....,******,*,,,...,......,,.......,..,,.,.%&&&@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@&&&.,.,,,,............,..............,,,*,....,,..*****,(@@,,,...,.........,,,,..........%&&&@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@&&&(..,,..............................,...,*,....,.,**,*@@*,,,...............,.,.... ....%&&@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@&&&.,*,,,*... ......................,.....,**,.. ..,**,@%*................,.,...,... ..%%&&@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@&&&#..,,.... .........................*...*,.......,.,,@@,,...............,......... ./%&&&@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@&&&/.,,,,*........ ............@@@@@@....,.....,.(.....@.. ... ....,..............   %&&&@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@&&&,..,,.......... ..........&@@@@@@@@@@@@@@@@@@@@@@.@@ ........................  .%%&&&@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@&&&#.....................,,,,%@@@@@@@@@@@@@@@@@@@@@@@%. ...................,,.  /%%&&&&@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@&&&% ...,.....  .......,,.,,#@@@@@@@@@@@@@@@@@@@@@@@ . .. .............. ..   %%&&&&@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@&&&%# . ..  ......... ... ,,**,,*,/@@@@@@@@@@@@@@@    .  ... ... .......   /%%&&&&@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@&&&&&*......................,,,...@@@@@@@@@*.........   ............    .%%&&&&&@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&(............................#@((@  . ... ,.   ......  ...     *%%&&&&&@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&%.  .......................@@.%@@.............        .   .%%%%&&&&@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&%%...... .... . ...... ..@ ... @@.........           .%%%%&&&&&@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&%%%   ....... .   .. %%... .. &@@  ..      ..  %%%%%&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&%%%#            *@%         @@*     ..#%%%%%%&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("These are your commands.");
        System.out.println("Talk, Look, Pickup, Go, Use, Drop");
        System.out.println("You can try to scream but no one will hear you.");
        System.out.println("You can combine these verbs with either location, person, or item.");
        System.out.println("Example: Go spaceport");
        System.out.println("To look at current inventory. Type in \"Inventory\"");

        System.out.println("Welcome to spaceport that you called home.... for now.");
        System.out.println("In the middle of the room there is an empty paper coffee cup");
        System.out.println("Looks like the coffee was drank by a random person that is standing creepily in the corner.");
        System.out.println("From here you can go to north, which miiiiight be north.");

        System.out.println(" What would you like to do? Hint: go north maybe");
        System.out.println("To quit type in the letter \"Q\"");
        System.out.print(": ");
        String choice = userInput.nextLine();

        if (choice.equalsIgnoreCase("Q")) {
            System.out.println("Whelp, you jumped into a black hole. Goodbye!");
            System.exit(0);
        } else if (choice.equalsIgnoreCase("inventory")) {
            for (String item : inventory) {
                System.out.println(item);
            }
        } else if (choice.equalsIgnoreCase("Talk Creep")) {

            Random random = new Random();
            int randomReply = random.nextInt(2); //Upper bound exclusive

            if (randomReply == 0) {
                System.out.println("You see there is garbage next to the Creeper and tell him to pick it");
                System.out.println("Yea that's my garbage! What you going to do about it!");
                System.out.println("As you turn around to walk away.... He sucker punches you!");
                health -= 1;
                System.out.println("You took damage.");
                System.out.println("Health: " + health + "/3");
            } else if (randomReply == 1) {
                System.out.println("You see there is garbage next to the Creeper and tell him to pick it");
                System.out.println("Creeper picks up his garbage and starts to walk away and drops it back on the ground");
            }
        } else if (choice.equalsIgnoreCase("Look North")) {
            System.out.println("That's where the the little voice told you to go");
            System.out.println("Its tantalizing");
        } else if (choice.equalsIgnoreCase("Look Creep")) {
            System.out.println("Creep notices you staring. He thinks you are a creep now.");
        } else if (choice.equalsIgnoreCase("Look Garbage")){
            System.out.println("Looks like its the Creeps garbage.");
        } else if(choice.equalsIgnoreCase("Look Terminal")) {
            System.out.println("Terminal is filled with random travelers going places. " +
                    "While you panic about losing the company spaceship");
        } else if(choice.equalsIgnoreCase("Pickup Garbage")) {
            inventory[1] = "Garbage";
            System.out.println("I mean... that's what you wanted. You got Garbage now.");
        } else if(choice.equalsIgnoreCase("Drop Garbage")) {
            inventory[1] = null;
            System.out.println("Don't know why you had Garbage in the first place.");
        } else if(choice.equalsIgnoreCase("Use Garbage") && inventory[1].equalsIgnoreCase("Garbage")) {
            System.out.println("Curiosity got the better of you and you eat some of the garbage.... Why!");
            inventory[1] = null;
            System.out.println("With how badly it tasted. You drop the garbage.");
            System.out.println("Again why did you taste it.");
        } else if (choice.equalsIgnoreCase("Use Garbage") && inventory[1] == null) {
            System.out.println("If you want to use the garbage. You would need to pick it up first.");
        }
        else if (choice.equalsIgnoreCase("Go North")) {
            System.out.println("You went north!");
            System.out.println("Whoops bad hint. You died!");
            System.out.println("New Hint: I'm an unreliable narrator!");
        } else {
            System.out.println("These are your commands.");
            System.out.println("Talk, Look, Pickup, Go, Use, Drop");
            System.out.println("You can try to scream but no one will hear you.");
            System.out.println("You can combine these verbs with either location, person, or item.");
            System.out.println("Example: Go spaceport");
            System.out.println("To look at current inventory. Type in \"Inventory\"");
            System.out.println(" What would you like to do? Hint: go north maybe");
            System.out.println("To quit type in the letter \"Q\"");
        }
    }
}
