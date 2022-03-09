package com.spaceforce.fileParsing;


import com.spaceforce.obj.Item;
import com.spaceforce.obj.Location;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JsonImporter {
    //Class object mapper to avoid garbage
    static ObjectMapper objectMapper = new ObjectMapper();
    static ArrayNode locationNodes;
    static ArrayNode itemNodes;
    static ArrayNode npcNodes;
    static { //static game object node arrays
        try {
            locationNodes = (ArrayNode) objectMapper.readTree(new FileInputStream("src/com/spaceforce/fileParsing/data/locations.json"));
            //itemNodes = (ArrayNode) objectMapper.readTree(new FileInputStream("src/com/spaceforce/fileParsing/data/items.json"));
            //npcNodes = (ArrayNode) objectMapper.readTree(new FileInputStream("src/com/spaceforce/fileParsing/data/npcs.json"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Checks provided id against json Location objects
    public static Location parseLocation(int id) throws IOException{
        Location location = null;
        //If json file has location of that id return it. Else throw exception
            if(locationNodes.has(id)){
                 location = objectMapper.readValue(locationNodes.get(id), Location.class);
                 return location;
            }
        if(location == null) throw new IOException("Location of id:"+id+" does not exist in json data file");
        return location;
    }

    //Checks provided id against json Item objects
    public static Item parseItem(String id) throws IOException{
        Item item = null;
        //for each json node, if its id matches map it as an Item and return it. Else throw exception
        for(JsonNode jsonNode: itemNodes){
            if(jsonNode.get("$id").toString().equalsIgnoreCase(id)){
                item = objectMapper.readValue(jsonNode, Item.class);
            }
        }
        if(item == null) throw new IOException("Location of id:"+id+" does not exist in json data file");
        return item;
    }

    /*
    //Checks provided id against json NPC objects
    public static NPC parseNPC(String id) throws IOException{
        NPC npc = null;
        //for each json node, if its id matches map it as an NPC and return it. Else throw exception
        for(JsonNode jsonNode: npcNodes){
            if(jsonNode.get("$id").toString().equalsIgnoreCase(id)){
                npc = objectMapper.readValue(jsonNode, NPC.class);
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



    public static void main(String[] args) {
        try{
            Location location = parseLocation(0);
            System.out.println(location.description);
            System.out.println(location.items[0].description);
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
