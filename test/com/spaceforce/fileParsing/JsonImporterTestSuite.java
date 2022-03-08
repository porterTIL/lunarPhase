package com.spaceforce.fileParsing;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.spaceforce.fileParsing.JsonImporter;
import com.spaceforce.obj.Location;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JsonImporterTestSuite {
    JsonObject control = new JsonObject();

    @Before
    public void init(){
        control = new JsonObject();
        control.put("description", "testing123");
    }
    @Test
    public void createLocationFromJsonTest(){
        String filePath = "test/com/spaceforce/fileParsing/testData/testLocation.json";
        try {
            Location variable = JsonImporter.parseLocation(filePath);
            assertEquals(variable.description, control.get("description"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void parseLocationBadFilePathTest(){
        String filePath = "testing123";
        try {
            Location variable = JsonImporter.parseLocation(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(e instanceof JsonFileException);
        }
    }
    @Test
    public void createItemFromJsonTest(){
        String filePath = "test/com/spaceforce/fileParsing/testData/testItem.json";
        try{
            Location variable = JsonImporter.parseLocation(filePath);
            assertEquals(variable.description, control.get("description"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
