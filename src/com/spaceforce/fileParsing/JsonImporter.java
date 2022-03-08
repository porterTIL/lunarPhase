package com.spaceforce.fileParsing;


import com.spaceforce.obj.Item;
import com.spaceforce.obj.Location;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonImporter {
    //Class object mapper to avoid garbage
    static ObjectMapper objectMapper = new ObjectMapper();

    //Creates a location instance from JSON file
    public static Location parseLocation(String path) throws IOException {
        Location location = null;
        try {
            location = objectMapper.readValue(new File(path), Location.class);
        } catch (JsonMappingException e){
            System.out.println(e.getLocation());
            throw new JsonFileException("Writers broke JSON file: " + path, e);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return location;
    }

    //Creates an item instance from JSON file
    public static Item parseItem(String path) throws IOException {
        Item item = null;
        try{
            item = objectMapper.readValue(new File(path), Item.class);
        } catch (JsonMappingException e){
            throw new JsonFileException("Writers broke JSON file: " + path, e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return item;
    }



    public static void main(String[] args) {
        try{
            Location location = parseLocation("com/spaceforce/fileParsing/act1/location1/location1.json");
            System.out.println(location.description);
            System.out.println(location.items[0].description);
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
