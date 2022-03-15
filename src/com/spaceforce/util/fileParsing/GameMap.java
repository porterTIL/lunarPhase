package com.spaceforce.util.fileParsing;

import com.spaceforce.obj.Location;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class GameMap {
    final static String startKey = "start";
    public static Location currentLocation;
    static Map<String, Location> locations;

    //fills static values
    public static void init(){
        //if locations hasn't been initialized, initialize it.
        if(locations == null){
            locations = formatArray(JsonImporter.parseAllLocations());
        } else {
            System.out.println("Already initialized");
        }
        if(locations.containsKey("start")){
            currentLocation = locations.get("start");
        } else {
            currentLocation = (Location)locations.values().toArray()[0];
        }
        currentLocation.initItems();
    }
    //Turns Location Array into a map with names as the key
    static Map<String, Location> formatArray(Location[] locationsArray){
        Map<String, Location> localMap = new HashMap<>();
        for(Location location: locationsArray){
            localMap.put(location.name, location);
        }
        return localMap;
    }

    //
    public static void goTo(String exit) throws IOException{
        if(currentLocation.checkExit(exit) && locations.containsKey(exit)){
            currentLocation = locations.get(exit);
            currentLocation.initItems();
        } else {
            throw new IOException(); //TODO write message
        }
    }

    public static Map<String, Location> getWorldState(){
        return locations;
    }
    public static void setWorldState(Map map){
        locations = map;
    }


}
