package com.spaceforce.fileParsing;

import com.fasterxml.jackson.core.JsonParseException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.spaceforce.fileParsing.JsonImporter;
import com.spaceforce.obj.Item;
import com.spaceforce.obj.Location;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class JsonImporterTestSuite {
    JsonObject control = new JsonObject();

    @Before
    public void init(){
        control = new JsonObject();
        control.put("description", "testing123");
    }
    @Test
    public void createLocationFromJsonTest(){
        try {
            Location variable = JsonImporter.parseLocation(0);
            assertEquals("Spaceport", variable.description);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void parseLocationBadFilePathTest(){
        String filePath = "testing123";
        try {
            Location variable = JsonImporter.parseLocation(0);
        } catch (IOException e) {
            assertTrue(!(e instanceof JsonParseException));
            assertTrue(e instanceof IOException); // when file path is bad it throws a new IOExc instead of passing the functions JsonParseException
        }
    }
    @Test
    public void parseLocationBadJsonFileTest(){
        String filePath = "test/com/spaceforce/fileParsing/testData/testBadData.json";
        try {
            Location variable = JsonImporter.parseLocation(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            assertEquals("Writers broke code at " + filePath, e.getMessage());
        }
    }
    @Test
    public void createItemFromJsonTest(){
        String filePath = "test/com/spaceforce/fileParsing/testData/testItem.json";
        try{
            Item variable = JsonImporter.parseItem(filePath);
            assertEquals(variable.description, control.get("description"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
