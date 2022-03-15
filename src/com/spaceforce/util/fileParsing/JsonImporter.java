package com.spaceforce.util.fileParsing;


import com.spaceforce.obj.Item;
import com.spaceforce.obj.Location;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;


import java.io.FileInputStream;
import java.io.IOException;

public class JsonImporter {
    static String filePath = "Resources/JSON/";
    public static ObjectMapper objectMapper = new ObjectMapper();
    static ArrayNode locationNodes;
    static ArrayNode itemNodes;
    static ArrayNode npcNodes;
    //call this on compilation
    static{initArrayNodes();}
    static void initArrayNodes(){ //static game object node arrays
        try {
            locationNodes = (ArrayNode) objectMapper.readTree(new FileInputStream(filePath+"locations.json"));
            itemNodes = (ArrayNode) objectMapper.readTree(new FileInputStream(filePath+"items.json"));
            npcNodes = (ArrayNode) objectMapper.readTree(new FileInputStream(filePath+"npcs.json"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //TESTING PURPOSES
    //Changes source of location
    public static void changeSource(String source){
        filePath = source;
        initArrayNodes();
    }
    //Checks provided id against json Location objects
    public static Location parseLocation(int id) throws IOException {
        Location location = null;
        //If json file has location of that id return it. Else throw exception
        if (locationNodes.has(id)) {
            location = objectMapper.readValue(locationNodes.get(id), Location.class);
            return location;
        }
        if (location == null) throw new IOException("Location of id:" + id + " does not exist in json source file");
        return location;
    }

    //Parse all Locations
    public static Location[] parseAllLocations() {
        int arraySize = locationNodes.size();
        Location[] locations = new Location[arraySize];
        try {
            for (int i = 0; i < arraySize; i++) {
                locations[i] = objectMapper.readValue(locationNodes.get(i), Location.class);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return locations;
    }

    //Checks provided id against json com.spaceforce.obj.Item objects
    public static Item parseItem(int id) throws IOException {
        Item item = null;
        //If json file has location of that id return it. Else throw exception
        if (itemNodes.has(id)) {
            item = objectMapper.readValue(itemNodes.get(id), Item.class);
            return item;
        }
        if (item == null) throw new IOException("Location of id:" + id + " does not exist in json data file");
        return item;
    }

}