/*
 * Eva Kinnel
 * Cafe class
 * Assignment 7
 * @author R. Jordan Crouser + CSC120 (Fall '22))
 */public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /** constructor for Cafe class
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

    }

    /** overloaded constructor for a Cafe (for potentially a manager of multiple of cafes who is familiar with addresses etc. and just wants to know info)
     * 
     * @param name
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

    }

    /** 
     * accessor for cafe inventory
     */
    public void getInventory(){
        System.out.println("Coffee (oz): " + nCoffeeOunces + "\nCups: " + nCups + "\nSugar Packets: " + nSugarPackets + "\nCreams: " + nCreams);
    }

    /** decreses the number for each value if it is "bought", and calls the restock method if the stock gets low
     * @param size
     * @param packetsUsed
     * @param creamsUsed
     */
    public void sellCoffee(int size, int packetsUsed, int creamsUsed){
        this.nCups = nCups - 1;
        this.nCoffeeOunces = nCoffeeOunces - size;
        this.nSugarPackets = nSugarPackets - packetsUsed;
        this.nCreams = nCreams - creamsUsed;

        if (nCoffeeOunces <= 30){
            System.out.println("Coffee Low");
            this.restock(0, 370, 0, 0);
            System.out.println("Coffee has been restocked");
        }
        if (nCups < 10){
            System.out.println("Cups Low");
            this.restock(550, 0, 0, 0);
            System.out.println("Cups have been restocked");
        }
        if (nSugarPackets < 10){
            System.out.println("Sugar Low");
            this.restock(0, 0, 90, 0);
            System.out.println("Sugar packets have been restocked");
        }
        if (nCreams < 6){
            System.out.println("Creams Low");
            this.restock(0, 0, 0, 194);
            System.out.println("Creams have been restocked");
        }
    }

    /** Overloaded method for selling coffee to imput a size name rather than ounce amount
     * 
     * @param size
     * @param packetsUsed
     * @param creamsUsed
     */
    public void sellCoffee(String size, int packetsUsed, int creamsUsed){

        if (size.equals("small")){
            this.nCoffeeOunces = nCoffeeOunces - 8;
        }
        if (size.equals("medium")){
            this.nCoffeeOunces = nCoffeeOunces - 12;
        }
        if (size.equals("large")){
            this.nCoffeeOunces = nCoffeeOunces - 16;
        }
        this.nCups = nCups - 1;
        this.nSugarPackets = nSugarPackets - packetsUsed;
        this.nCreams = nCreams - creamsUsed;

        // is it possible to super the restocking stuff from the og sellCoffee()?
    }

    /** increases each value by a ceratain amount
     * @param plusCups
     * @param plusCoffee
     * @param plusPackets
     * @param plusCreams
     */
    private void restock(int plusCups, int plusCoffee, int plusPackets, int plusCreams){
        this.nCups = nCups + plusCups;
        this.nCoffeeOunces = nCoffeeOunces + plusCoffee;
        this.nSugarPackets = nSugarPackets + plusPackets;
        this.nCreams = nCreams + plusCreams;
    }

    /**
     * disallows people from traveling between floors of a cafe
     */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("You are not allowed access to that floor.");
    }
    
    /**
     * Shows all of the available fucntions of the cafe
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + getInventory()\n + sellCoffe(size, packetsUsed, creamsUsed)\n + restock(plusCups, plusCoffee, plusPackets, plusCreams)");
        // no goUp(), goDown(), goToFloor(n)
    }

    public static void main(String[] args) {
        Cafe coffEva = new Cafe("COFFEva HOUSEva", "648 Elephant Plush Way", 1, 400, 100, 200, 600);
        // coffEva.getInventory();
        // coffEva.sellCoffee(8, 0, 1);
        // coffEva.getInventory();
        // coffEva.sellCoffee(350, 8, 1);
        // coffEva.getInventory();
        // coffEva.sellCoffee(15, 0, 1);
        coffEva.getInventory();
        // coffEva.sellCoffee("small", 2, 4);
        // coffEva.goToFloor(5);
        // coffEva.getInventory();
    }
    
}
