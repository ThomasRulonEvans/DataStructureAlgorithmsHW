//Thomas Evans
//Assignment #4
//2235 - 01
//Scoreboard

//Scoreboard class for Homework 4
//Define program class
public class Scoreboard{
  //Instance Variables
  private int numEntries =0;
  private GameEntry[] board;

  //Constructor
  //Making an Empty Scoreboard
  public Scoreboard(int capacity){
    board = new GameEntry[capacity];
  }
  //Method
  public void add(GameEntry e){
    //Check to see if the score is high enough
    int newScore =e.getScore();
    //This assumes our array is already sorted from highest to lowest
    if(numEntries < board.length || newScore > board[numEntries-1].getScore()){
      if(numEntries < board.length){//No score needs to be dropped
        numEntries++;
      }
      int j = numEntries-1;
      while(j>0 && board[j-1].getScore()< newScore){
        board[j]=board[j-1];
        j--;
      }
      board[j]=e;
    }
  }
  //Remove Element Method
  //This method will return and remove the element
  public GameEntry remove(int i) throws IndexOutOfBoundsException{
    if(i <0 || i>=numEntries){
      throw new IndexOutOfBoundsException("Invalid index: " + i);
    }
    GameEntry temp = board[i];
    for(int j=i; j<numEntries-1; j++){
      board[j]=board[j+1];
    }
    board[numEntries-1]=null;
    numEntries--;
    return temp;
  }

  //Method to print every entry based on index
  public void printScoreboard(){
    for (int i = 0; i < numEntries; i++){
        GameEntry currentEntry = board[i];
        System.out.println(currentEntry.getName() + " " + currentEntry.getScore());
    }
  }

  //Method to collect and compare entry values
  public void printScoreboardSummary(){
      
    //print number of entries/ highest-lowest scores/ range of scores/ average score
    //Integers,ints,Strings to collect
    Integer minScore = null;
    String minName = "";
    Integer maxScore = null;
    String maxName = "";
    int totalScore = 0;

    //Find smallest and largest values and their attached names
    for (int i = 0; i < numEntries; i++){
        GameEntry currentEntry = board[i];
        
        //Finds smallest value through comparison 
        if (minScore == null || minScore > currentEntry.getScore()){
            minScore = currentEntry.getScore();
            minName = currentEntry.getName();
        }  

        //Finds largest value through comparison 
        if (maxScore == null || maxScore < currentEntry.getScore()){
            maxScore = currentEntry.getScore();
            maxName = currentEntry.getName();
        }

        //Simple math to receive total for average calculation
        totalScore += currentEntry.getScore();
    }

    System.out.println("Scoreboard Summary");
    System.out.println("The total number of entries is: "+ numEntries);
    System.out.println("The highest score is: " + maxScore + " by: " + maxName);
    System.out.println("The lowest score is: " + minScore + " by: " + minName);
    //Score range math done inline
    System.out.println("The range of the scores is: " + (maxScore - minScore));
    //Rest of average score math done inline
    System.out.println("The average score is: " + (totalScore / numEntries));
  }
}