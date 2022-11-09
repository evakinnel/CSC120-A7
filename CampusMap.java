import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Coconut Palace", "23 Brown Street Northampton, MA 01063", 3));
        myMap.addBuilding(new House("Cool House", "90000 Star Court Flower, MN 97532", 2, false, false));
        myMap.addBuilding(new House("Tall House", "7 Tiny Road Petit, SM 02937", 70, true, false));
        myMap.addBuilding(new Cafe("Whoa There Cafe", "849 Magic Horse Road Allenchester, NJ 12345", 2, 100, 100, 100, 100));
        myMap.addBuilding(new Cafe("Unknown Address Cafe", 900, 795, 970, 1000));
        myMap.addBuilding(new Library("Oops Not Smith Library", "2 Nowhere Way Bedshire, KS", 2));
        myMap.addBuilding(new House("Eva's Mysterious House"));
        myMap.addBuilding(new Library("Library for Dogs"));
        myMap.addBuilding(new Cafe("Coffee House of the Moon", 45, 6, 84, 383));
        myMap.addBuilding(new House("Running Out of Names", "2038 Far Away Place Greenburg, RP 61616", 6, false, true));

        System.out.println(myMap);
    }
    
}
