//Thomas Evans
//Assignment #4
//2235 - 01
//Scoreboard

//Scoreboard test class
import java.util.Random;

public class ScoreboardTest {

    //Define main
    public static void main(String[] args) {

        //var for scoreboard size changes
        int scoreboardSize = 20;

        //initialize scoreboard with scoreboardSize
        Scoreboard myScoreboard = new Scoreboard(scoreboardSize);

        //random number generator 
        Random numRandom = new Random();

        //generate player names 1-20 and random score for each
        for (int i = 1; i <= scoreboardSize; i++){
            String playerName = "Player " + i;
            int playerScore = numRandom.nextInt(1000);
            GameEntry randomGameEntry = new GameEntry(playerName, playerScore);
            myScoreboard.add(randomGameEntry);
        }

        //print scoreboard after generation
        System.out.println("Scoreboard:");
        System.out.println("Name       Score");
        myScoreboard.printScoreboard();
        myScoreboard.printScoreboardSummary();

        //remove random entry from scoreboard
        myScoreboard.remove(numRandom.nextInt(scoreboardSize-1));

        //reprint scoreboard and summary after changes
        System.out.println("Scoreboard:");
        System.out.println("Name       Score");
        myScoreboard.printScoreboard();
        myScoreboard.printScoreboardSummary();
    }
}
