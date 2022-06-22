//Thomas Evans
//Assignment #6
//2235 - 01
//Scoreboard analysis

//Scoreboard test class
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreboardTest {
    //Define main
    public static void main(String[] args) {

        //make list to use as seed for scoreboard size
        int[] list = {100, 1000, 10000, 50000, 100000, 500000};

        //for loop based on persistent size of "list" array
        for (int b = 0; b < 6; b++){

            //var for scoreboard size changes
            Integer scoreboardSize = list[b];

            //initialize scoreboard with scoreboardSize
            Scoreboard myScoreboard = new Scoreboard(scoreboardSize);

            //random number generator 
            Random numRandom = new Random();

            //print scoreboard size
            System.out.println("The size of this scoreboard is " + scoreboardSize + " items.");

            //grab time before computing
            long time1 = System.currentTimeMillis();
            
            //generate player names 1-x and random score for each
            for (int i = 1; i <= scoreboardSize; i++){
                String playerName = "Player " + i;
                int playerScore = numRandom.nextInt(1000);
                GameEntry randomGameEntry = new GameEntry(playerName, playerScore);
                myScoreboard.add(randomGameEntry);
            }

            //grab time after computing
            long time2 = System.currentTimeMillis();

            //calculate time elapsed
            long totalTime = time2 - time1;

            //print time elapsed
            System.out.println("The time to compute is " + totalTime + "ms.");
        }
    }
}
