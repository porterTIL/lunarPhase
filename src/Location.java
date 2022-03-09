import java.io.File;

public class Location implements Interaction{
    File locationFile;

    // should we have an index of location files and give each location it's own file?
    private Location (File locationFile){
        locationFile = this.locationFile;
    }

    Location createLocation(File locationFile){
        return new Location(locationFile) ;
    }

    // TODO: read location description from JSON
    public void look(){
        // System.out.println(locationFile.description);
    };

    public void talk(){
        System.out.println("You speak into the void");
    }

    public void pickup(){
        System.out.println("You attempt to pick up the location, it goes as expected");
    };

    public void go(){ // IN IMPLEMENTATION COMPARE USER INPUT TO REACHABLE LOCATIONS FROM THIS LOCATION
        System.out.println("You can't reach that location from here");
    };


    public void drop(){
        System.out.println("You attempt to drop the location, who knows what you're thinking?");
    };

    public void use(){
        System.out.println("This isn't a restroom, you shouldn't do that here");
    };
}