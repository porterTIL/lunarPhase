package com.spaceforce.fileParsing;


import com.spaceforce.obj.Item;
import com.spaceforce.obj.Location;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;


import java.io.FileInputStream;
import java.io.IOException;

public class JsonImporter {
    static String filePath = "Resources/JSON/";
    static ObjectMapper objectMapper = new ObjectMapper();
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

    //Checks provided id against json Item objects
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
    /*
    //Checks provided id against json NPC objects
    public static NPC parseNPC(int id) throws IOException {
        NPC npc = null;

            if (npcNodes.has(id)) {
                npc = objectMapper.readValue(npcNodes.get(id), NPC.class);
                return npc;
            }
        if (npc == null) throw new IOException("Location of id:" + id + " does not exist in json data file");
        return npc;
    }
       */
    /*
    //Checks provided id against json com.spaceforce.obj.NPC objects
    public static com.spaceforce.obj.NPC parseNPC(String id) throws IOException{
        com.spaceforce.obj.NPC npc = null;
        //for each json node, if its id matches map it as an com.spaceforce.obj.NPC and return it. Else throw exception
        for(JsonNode jsonNode: npcNodes){
            if(jsonNode.get("$id").toString().equalsIgnoreCase(id)){
                npc = objectMapper.readValue(jsonNode, com.spaceforce.obj.NPC.class);
            }
        }
        if(npc == null) throw new IOException("Location of id:"+id+" does not exist in json data file");
        return npc;
    }*/

    //Creates an item instance from JSON file
    /*
    public static Item parseItem(String path) throws IOException {
        Item item = null;
        File file = new File(path);
        if(file.isFile()) {
            try {
                item = objectMapper.readValue(file, Item.class);
            } catch (IOException e){
                throw new IOException("Writers broke JSON file at " + path);
            }
        }
        return item;

    }
    */
    //Creates a location instance from JSON file
    /*
    public static Location parseLocation(String path) throws IOException {
        Location location = null;
        File file = new File(path);
        if(file.isFile()) {
            try{
                location = objectMapper.readValue(file, Location.class);
            } catch (AssertionError e){
                throw new IOException("Writers broke JSON file at " + path);
            }
        } else throw new IOException("Invalid Path");
        return location;
    }
     */
    /*
    public static NPC parseNPC(String path) throws IOException {
        NPC npc = null;
        File file = new File(path);
        if(file.isFile()){
            try{
                npc = objectMapper.readValue(file, NPC.class);
            } catch (IOException e){
                throw new IOException();
            }
        }
    }
*/