package com.spaceforce.game;

import com.spaceforce.util.fileParsing.JsonImporter;
import com.spaceforce.obj.Location;

import java.io.IOException;
import java.util.Scanner;

public class LunarGame {
    public static void main(String[] args) throws IOException { // be mad >:(
        Scanner in = new Scanner(System.in);
        Location currentLocation = JsonImporter.parseLocation(0);
        String[] input = null;
        while(true){
            while(input == null||input.length != 2) input = breakString(in.nextLine());
            input=null;
        }
    }
    static String[] breakString(String scannerIn){
        return scannerIn.split(" ");
    }
   /* String playerCommands[] = new ArrayList<>("look", "take", "go");
    List<String> worldObjects = new ArrayList<>("North", "East", "West", "South");
    Scanner input = new Scanner(System.in);

    public LunarGame(){}

    public String useVerb(List<String> playerCommands){
        String verb;
        String msg= "";
        verb = playerCommands.get(0);

        if (!playerCommands.contains(verb)) {
            msg = verb + "is not a usable verb...";
        } else {
            msg = verb;
        }
        return msg;
    }

    public String useNoun(List<String>wordlist) {
        String noun;
        String msg = "";
        noun = wordlist.get(1);
        if (!worldObjects.contains(noun)) {
            msg = noun + "is not a usable noun...";
        } else {
            msg = noun;
        }
        return msg;*/
}
