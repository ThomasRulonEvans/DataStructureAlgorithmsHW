//Thomas Evans
//MidProject
//2235 - 01
//War 1000 games class

public class WarTests {

    //constructor for war
    public WarTests(){
        //statistic vars
        int numRounds = 0;
        int numWars = 0;
        int numWinsP1 = 0;
        int numWinsP2 = 0;

        //play 1000 games while collecting number of rounds/wars/wins
        for(int i = 0; i < 1000; i++){
            War war = new War(true);
            numRounds += war.getNumRounds();
            numWars += war.getNumWars();
            numWinsP1 += war.getWinsP1();
            numWinsP2 += war.getWinsP2();
        }

        //calculate averages
        double avgRounds = numRounds / 1000;
        double avgWars = numWars / 1000;

        //print results
        System.out.println("There was an average of " + avgRounds + " rounds per game of War.");
        System.out.println("There was an average of " + avgWars + " wars per game of War.");
        System.out.println("Player 1 won " + numWinsP1 + " games of war of 1000 played.");
        System.out.println("Player 2 won " + numWinsP2 + " games of war of 1000 played.");
    }

    public static void main(String[] args) {
        WarTests wargame = new WarTests();
    }
}
