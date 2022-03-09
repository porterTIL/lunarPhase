import java.io.File;

public class Item implements Interaction{
    File itemFile;

    // should we have an index of location files and give each location it's own file?
    private  Item(File itemFile){
        itemFile = this.itemFile;
    }

    Item createItem(File itemFile){
        return new Item(itemFile);
    }

    // TODO: read location description from JSON
    public void look(){
        // System.out.println(itemFile.description);
    };

    public void talk(){
        System.out.println("Talking to inanimate objects is the first sign of space psychosis");
    }

    public void pickup(){
        // add item to inventory
    };

    public void go(){ // IN IMPLEMENTATION COMPARE USER INPUT TO REACHABLE LOCATIONS FROM THIS LOCATION
        System.out.println("You tell it to go, but it just can't seem to leave you");
    };

    public void drop(){
        // remove item from inventory
        // place item into location
    };

    public void use(){
        // item specific behavior
    };
}
