//Thomas Evans
//Assignment #5
//2235 - 01
//Scoreboard with linked lists

//DoublyLinkedListTest test class
import java.util.Random;

//initialize class
public class DoublyLinkedListTest {

    //Define main
    public static void main(String[] args) {

        //var for scoreboard size changes
        int listSize = 20;

        //initialize scoreboard with scoreboardSize
        DoublyLinkedList<GameEntry> myList = new DoublyLinkedList<GameEntry>();

        //random number generator 
        Random numRandom = new Random();

        //generate player names 1-20 and random score for each
        for (int i = 1; i <= listSize; i++){
            String playerName = "Player " + i;
            int playerScore = numRandom.nextInt(1000);
            GameEntry randomGameEntry = new GameEntry(playerName, playerScore);
            myList.addLast(randomGameEntry);
        }

        //print scoreboard after generation
        System.out.println("Scoreboard:");
        System.out.println("Name       Score");
        printList(myList);
        printListSummary(myList);

    }

    //Cycles through the list to print from first to last
    public static void printList(DoublyLinkedList<GameEntry> myList){
        for (int i = 0; i < myList.getSize(); i++){
            GameEntry currentEntry = myList.first();
            System.out.println(currentEntry.getName() + " " + currentEntry.getScore());
            //move this to the end because it is processed
            myList.addLast(currentEntry);
            myList.removeFirst();
        }
      }
    
    //Method to collect and compare entry values
    public static void printListSummary(DoublyLinkedList<GameEntry> myList){
        
        //print number of entries/ highest-lowest scores/ range of scores/ average score
        //Integers,ints,Strings to collect
        Integer minScore = null;
        String minName = "";
        Integer maxScore = null;
        String maxName = "";
        int totalScore = 0;

        //Find smallest and largest values and their attached names
        for (int i = 0; i < myList.getSize(); i++){
            GameEntry currentEntry = myList.first();
        
            
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

            //move this to the end because it is processed
            myList.addLast(currentEntry);
            myList.removeFirst();
        }

        //prints the summary formatting and values
        System.out.println("Scoreboard Summary");
        System.out.println("The total number of entries is: "+ myList.getSize());
        System.out.println("The highest score is: " + maxScore + " by: " + maxName);
        System.out.println("The lowest score is: " + minScore + " by: " + minName);
        //Score range math done inline
        System.out.println("The range of the scores is: " + (maxScore - minScore));
        //Rest of average score math done inline
        System.out.println("The average score is: " + (totalScore / myList.getSize()));
    }
}