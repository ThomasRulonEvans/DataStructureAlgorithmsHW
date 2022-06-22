//Thomas Evans
//Assignment #6
//2235 - 01
//Scoreboard analysis

//Game Entry Class for HW 4
//Define program
public class GameEntry{
  //Instance Variables
  private String name;
  private int score;

  //Constructor
  public GameEntry(String n, int s){
    name=n;
    score=s;
  }
  //Getter methods
  public String getName(){return name;}
  public int getScore(){return score;}
  public String toString(){return "(" + name + "," + score + ")";}
}