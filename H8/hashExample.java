//Hash Table example for lecture on 4-6-2021
//Import libraries
import java.util.Hashtable;

//Declare program class
public class hashExample{

  //Main method
  public static void main(String[] args){
    //Create a Hash table with ints for keys and strings for values
    Hashtable<Integer, String> myHashTable = new Hashtable<Integer, String>();

    //Insert some values into our hash table
    myHashTable.put(5, "A");
    myHashTable.put(7, "B");
    myHashTable.put(6, "C");
    myHashTable.put(2, "D");
    myHashTable.put(0, "F");

    //Print hash code
    System.out.println("This hashtable uses the hash code: "
     + myHashTable.hashCode());

    //check values inside by key
    System.out.println(myHashTable.get(5));
    //Remove value at 5
    System.out.println(myHashTable.remove(5));
    //Print collection of keys and values
    System.out.println(myHashTable.entrySet());
  }
}