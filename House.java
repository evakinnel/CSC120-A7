/*
 * Eva Kinnel
 * House class
 * Assignment 7
 * @author R. Jordan Crouser + CSC120 (Fall '22))
 */
import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

   /** constructor for House class
    * 
    * @param String name - building name, String address - building address, int nFloors - number of floors, boolean hasDiningRoom - whether the house has a dining room
    */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<String>();
    this.hasElevator = hasElevator;
  }

  /** Overloaded constructor for a simpler house
   * 
   * @param name the name of the house
   */
  public House(String name) { 
    super(name);
    this.residents = new ArrayList<String>();
  }

   /** accessor for dining room status (true or false)
    * 
    * @return boolean - whether or not the House has a dining room
    */
  public boolean hasDiningRoom(){
    if (hasDiningRoom == true){
      return true;
    } else{
      return false;
    }
  }

   /** accessor for number of House residents
    * 
    * @return int size - the number of residents currently in the House
    */
  public int nResidents(){
    return this.residents.size();
  }

  /** adds a resident to the residents arrayList by name
   * 
   * @param String name - the name of a resident to be added to the house arrayList
   */
  public void moveIn(String name){
    residents.add(name);
  }

  /** removes a resident from the residents arrayList by name
   * 
   * @param String name - the name of a resident to be removed from the house arrayList
   * @return String - the name of the resident that was removed
   */
  public String moveOut(String name){ // return the name of the person who moved out
    residents.remove(name);
    return name;
  } 

  /** return the location in the array that the person was removed from
   * 
   * @param spot the place to be removed
   * @return int the spot in the array
   */
  public int moveOut(int spot){
    residents.remove(spot);
    return spot;
  } 

  /** checks if a specific name is in list residents
   * 
   * @param String person - the name of a person whose residency is being questioned
   * @return boolean - whether or not that person is in the house
   */
  public boolean isResident(String person){
    if (residents.contains(person)){
      System.out.println("Yes, " + person + " is a resident");
      return true;
    } else{
      System.out.println("No, " + person + " is not a resident");
      return false;
    }

  }

  /**
   * show all methods available for house class
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom()\n + nResidents()\n + moveIn(name)\n + moveOut(name)\n + isResident(person)");
  }

  /**
   * change floors
   */
  public void goToFloor(int floorNum) {
    if(this.hasElevator == true){
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    } else{
      throw new RuntimeException("This building does not have an elevator. Cannot move between floors.");
    }
  }

  public static void main(String[] args) {
    House wilder = new House("Wilder House", "1 Mandelle Road", 4, true, true);
    wilder.moveIn("Eva");
    // wilder.moveOut("Eva");s
    wilder.isResident("Eva");
    System.out.println(wilder.residents);
    wilder.moveOut(0);
    System.out.println(wilder.residents);
  }

}

