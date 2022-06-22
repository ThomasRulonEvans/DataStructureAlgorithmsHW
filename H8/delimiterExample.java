//Delimeter Example for lecture on 04-08-21
//Import library
import java.util.Scanner;

//Define program class
public class delimiterExample{

  //Define main
  public static void main(String[] args){
    //Create a scanner object to work with
    Scanner list = new Scanner("Alex 12, Michael 13, Joel 14, Paul 15, David 16");
    //System.out.println(list);//This doesn't help alot

    list.useDelimiter("[^B-Zb-z]+"); //1st delimiter

    while(list.hasNext()){
      String name = list.next();
      System.out.println(name);
    }
  }
}