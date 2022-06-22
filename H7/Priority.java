//PQ Example for lecture on 3-30-21
//Import Libraries
import java.util.PriorityQueue;
import java.util.Iterator;

//Define program class
public class Priority{
  //Program Main
  public static void main(String[] args){
    //Create a Priority Queue
    PriorityQueue<String> MyPQ = new PriorityQueue<String>();

    //Populate the PQ
    MyPQ.add("Student 1");
    MyPQ.add("Student 2");
    MyPQ.add("Student 3");
    MyPQ.add("Student 4");

    //Print first student
    System.out.println("The first element in the PQ is: " + MyPQ.peek());

    //Note the PQ will use natural order by default with primitives or Strings
    //We can use the Comparator Method to see if are using natural order
    //If we are using natural order it will return null

    //Take a look at the Comparator
    System.out.println(MyPQ.comparator());

    //Lets create another PQ
    PriorityQueue<String> MyStudents = new PriorityQueue<String>();

    //Add some students to the PQ
    MyStudents.add("Micheal");
    MyStudents.add("Baylor");
    MyStudents.add("Alex");
    MyStudents.add("David");

    //Which student should be printed first?
    System.out.println("The first student in the PQ is: " + MyStudents.peek());

    //Iterator for MyStudents PQ
    //Remenber Iterators are objects
    System.out.println("The students in the PQ are: " + MyStudents.iterator());

    Iterator MyStudentsIterator = MyStudents.iterator();

    //Print the contents of the iterator
    while(MyStudentsIterator.hasNext()){
      System.out.println(MyStudentsIterator.next() + " ");
    }
  }
}