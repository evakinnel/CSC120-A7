/*
 * Eva Kinnel
 * A7
 * Desc: Sample solution for the Library class (CSC120: A6)
 * Author: R. Jordan Crouser
 *   Date: 6-Nov-2022
 */


import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  /**
   * constructor for Library class
   * @param name
   * @param address
   * @param nFloors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String,Boolean>();
  }

  /**
   * Overloaded constructor for Library with only the name
   * @param name
   */
  public Library(String name) {
    super(name);
    this.collection = new Hashtable<String,Boolean>();
  }
  
  /**
   * add a book to the hash table
   * @param title
   */
  public void addTitle(String title) {
    if (this.collection.containsKey(title)) {
      throw new RuntimeException("Collection already contains title ("+ title +") and this simple example doesn't handle duplicates.");
    } 
    this.collection.put(title, true);
  }

  /**
   * remove a book from the hashtable
   * @param title
   * @return
   */
  public String removeTitle(String title) {
    if (!this.collection.get(title)) {
      throw new RuntimeException("Selected title (" + title + ") is checked out, and cannot be removed from the collection until returned.");
    } 
    this.collection.remove(title);
    return title;
  }

  /**
   * change checkout status from false to true
   * @param title
   */
  public void checkOut(String title) {
    if (!this.collection.get(title)) {
      throw new RuntimeException("Selected title (" + title + ") is already checked out. Please try again later.");
    }
    this.collection.replace(title, false);
  }

  /**
   * change checkout status from true to false
   * @param title
   */
  public void returnBook(String title) {
    if (this.collection.get(title)) {
      throw new RuntimeException("Selected title (" + title + ") is not currently checked out.");
    }
    this.collection.replace(title, true);
  }

  /**
   * Tells if a title is in the collection
   * @param title
   * @return boolean if contained or not
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /**
   * tells if a title is available to be checked out
   * @param title
   * @return boolean 
   */
  public boolean isAvailable(String title) {
    return this.collection.get(title);
  }

  /**
   * print the library colleciton
   */
  public void printCollection() {
    System.out.println("*".repeat(11+this.name.length()));
    System.out.println(this.name + " Collection");
    System.out.println("*".repeat(11+this.name.length()));
    for (String key : this.collection.keySet()) {
      System.out.print(key + " (");
      if (this.collection.get(key)) {
        System.out.println("available)");
      } else {
        System.out.println("checked out)");
      }
    }
  }

  /**
   * show all methods abailable in Library
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)");
  }

  /**
   * change floors
   */
  public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    } 

  public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4);
    neilson.addTitle("The Lorax by Dr. Seuss");
    neilson.printCollection();
  }
  
}