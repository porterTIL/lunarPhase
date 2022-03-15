package com.spaceforce.player.save;

import com.spaceforce.obj.Item;
import com.spaceforce.obj.Location;
import com.spaceforce.player.Player;
import com.spaceforce.util.fileParsing.GameMap;
import com.spaceforce.util.fileParsing.JsonImporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class Save {
    static String savePath = "src/com/spaceforce/player/save/";

    Map<String, Location> gameMap;
    String name;
    int health;
    List<Item> inventory;

    //hidden constructor
    private Save(){};
    //calls all data grabbing methods
    static Save createInstance(){
        Save thisGame = new Save();
        thisGame.saveGameMap();
        thisGame.savePlayerInfo();
        return thisGame;
    }

    void saveGameMap() {
        this.gameMap = GameMap.getWorldState();
    }
    void loadGameMap() {
        GameMap.setWorldState(gameMap);

    }

    void savePlayerInfo() {
        this.name = Player.name;
        this.health =Player.health;
        this.inventory = Player.inventory;
    }
    void loadPlayerInfo() {

    }

    static File findSave() throws IOException {
        File save = new File(savePath+"save.dat");
        if(!save.isFile()){
            save.createNewFile();
        }
        return save;
    }
    //
    public static void saveData(){
        try {
            //write locations
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(findSave()));
            oos.writeObject(createInstance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean hasSave(){
        File save = new File(savePath+"save.dat");
        if(save.isFile()){
            return true;
        } else {
            return false;
        }
    }
    public static void loadData(){
        try {
            Save save = JsonImporter.objectMapper.readValue(savePath+"save.dat", Save.class);
            save.loadPlayerInfo();
            save.loadGameMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
