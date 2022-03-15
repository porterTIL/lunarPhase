package com.spaceforce.util.fileParsing;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.spaceforce.obj.Item;
import com.spaceforce.obj.Location;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class JsonImporterTestSuite {
    JsonObject control = new JsonObject();
    static {
        JsonImporter.changeSource("Resources/Test/JSON/");
    }


    @Before
    public void init(){
        control = new JsonObject();
    }

    //successful permutation
    @Test
    public void createLocationFromJsonTest(){
        try {
            Location variable = JsonImporter.parseLocation(0);
            System.out.println(variable.description);
            assertEquals("testing123", variable.description);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void parseLocationBadIdTest(){
        try{
            JsonImporter.parseLocation(-1);
        } catch (IOException e) {
            e.printStackTrace();
            assertFalse(e instanceof JsonMappingException);
        }
    }
    @Test
    public void createItemFromJsonTest(){
        try{
            Item variable = JsonImporter.parseItem(0);
            assertEquals(variable.lookMsg, control.get("description"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parseLocationBadJsonFileTest(){
        JsonImporter.changeSource("Resources/Test/JSON/BadFiles/");
        try {
            Location variable = JsonImporter.parseLocation(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            assertTrue(e instanceof JsonMappingException);
        }
    }
}
