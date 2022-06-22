//Thomas Evans
//Assignment #6
//2235 - 01
//Scoreboard analysis

//SinglyLinkedList test class
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//initialize class
public class SinglyLinkedListTest {

    //Define main
    public static void main(String[] args) {
         //make list to use as seed for scoreboard size
         int[] list = {100, 1000, 10000, 50000, 100000, 500000};

         //for loop based on persistent size of "list" array
         for (int b = 0; b < 6; b++){

            //var for list size changes
            int listSize = list[b];

            //initialize list with listSize
            SinglyLinkedList<GameEntry> myList = new SinglyLinkedList<GameEntry>();

            //random number generator 
            Random numRandom = new Random();

            //print scoreboard size
            System.out.println("The size of this scoreboard is " + listSize + " items.");

            //grab time before computing
            long time1 = System.currentTimeMillis();

            //generate player names 1-20 and random score for each
            for (int i = 1; i <= listSize; i++){
                String playerName = "Player " + i;
                int playerScore = numRandom.nextInt(1000);
                GameEntry randomGameEntry = new GameEntry(playerName, playerScore);
                myList.addLast(randomGameEntry);
            }

            //grab time after computing
            long time2 = System.currentTimeMillis();

            //calculate time elapsed
            long totalTime = time2 - time1;

            //print time elapsed
            System.out.println("The time to compute is " + totalTime + "ms.");
         }
    }

    // //Cycles through the list to print from first to last
    // public static void printList(SinglyLinkedList<GameEntry> myList){
    //     for (int i = 0; i < myList.getSize(); i++){
    //         GameEntry currentEntry = myList.first();
    //         System.out.println(currentEntry.getName() + " " + currentEntry.getScore());
    //         //Moves previously printed entry to the end since it has been printed.
    //         myList.addLast(currentEntry);
    //         myList.removeFirst();
    //     }
    //   }
    
    // //Method to collect and compare entry values
    // public static void printListSummary(SinglyLinkedList<GameEntry> myList){
        
    //     //print number of entries/ highest-lowest scores/ range of scores/ average score
    //     //Integers,ints,Strings to collect
    //     Integer minScore = null;
    //     String minName = "";
    //     Integer maxScore = null;
    //     String maxName = "";
    //     int totalScore = 0;

    //     //Find smallest and largest values and their attached names
    //     for (int i = 0; i < myList.getSize(); i++){
    //         GameEntry currentEntry = myList.first();
        
            
    //         //Finds smallest value through comparison 
    //         if (minScore == null || minScore > currentEntry.getScore()){
    //             minScore = currentEntry.getScore();
    //             minName = currentEntry.getName();
    //         }  

    //         //Finds largest value through comparison 
    //         if (maxScore == null || maxScore < currentEntry.getScore()){
    //             maxScore = currentEntry.getScore();
    //             maxName = currentEntry.getName();
    //         }

    //         //Simple math to receive total for average calculation
    //         totalScore += currentEntry.getScore();

    //         //move this to the end because it is processed
    //         myList.addLast(currentEntry);
    //         myList.removeFirst();
    //     }
        
    //     //prints the summary formatting and values
    //     System.out.println("Scoreboard Summary");
    //     System.out.println("The total number of entries is: "+ myList.getSize());
    //     System.out.println("The highest score is: " + maxScore + " by: " + maxName);
    //     System.out.println("The lowest score is: " + minScore + " by: " + minName);
    //     //Score range math done inline
    //     System.out.println("The range of the scores is: " + (maxScore - minScore));
    //     //Rest of average score math done inline
    //     System.out.println("The average score is: " + (totalScore / myList.getSize()));
}