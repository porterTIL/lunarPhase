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
    public void init(){
        //if locations hasn't been initialized, initialize it.
        if(locations == null){
            locations = formatArray(JsonImporter.parseAllLocations());
            if(locations.containsKey(startKey)){
                currentLocation = locations.get(startKey);
            } else {
                currentLocation = (Location) locations.values().toArray()[0];
            }
        } else {
            System.out.println("Already initialized");
        }
    }
    //Turns Location Array into a map with names as the key
    static Map formatArray(Location[] locationsArray){
        Map<String, Location> localMap = new HashMap<>();
        for(Location location: locationsArray){
            localMap.put(location.name, location);
        }
        return localMap;
    }

    //
    public void goTo(String exit) throws IOException{
        if(currentLocation.checkExit(exit) && locations.containsKey(exit)){
            currentLocation = locations.get(exit);
        } else {
            throw new IOException(); //TODO write message
        }
    }


}
