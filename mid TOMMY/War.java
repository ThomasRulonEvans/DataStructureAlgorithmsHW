//Thomas Evans
//MidProject
//2235 - 01
//War main class

//import libs
import java.io.StringReader;
import java.util.Scanner;

//define class
public class War {
    //instance variables
    //prize pool deck
    private Deck poolDeck = new Deck(true);
    //var to toggle print
    private boolean silentWar = false;
    //vars for statistics counters
    private int numRounds = 0;
    private int numWars = 0;
    private int numWinsP1 = 0;
    private int numWinsP2 = 0;

    //getters for statistics
    public int getNumRounds(){
        return numRounds;
    }
    public int getNumWars(){
        return numWars;
    }
    public int getWinsP1(){
        return numWinsP1;
    }
    public int getWinsP2(){
        return numWinsP2;
    }

    //constructor for war
    //includes boolean to toggle the print outs during game
    public War(boolean isSilentWar){
        //sets local variable for silencing war
        silentWar = isSilentWar;

        //initialize the game
        initialize();
    }

    //enable/disable print statements
    private void print(String printValue){
        if(silentWar == false){
            System.out.println(printValue);
        }
    }

    //grab card info and move it to pool deck, returns played card for comparison
    public Card playCard(Player player){
        Card card = player.dealCard();
        poolDeck.addCard(card);
        return card;
    }

    //method for a battles and wars
    //wars iterate over this class a second time to get war effect
    public Player battle(Player player1, Player player2, boolean isWar){
        //instance variables to hold card values for comparisons
        Card p1Card = playCard(player1);
        Card p2Card = playCard(player2);
        //state holder variable for whether or not to run as a war
        Player winner;

        //If isWar is true two more cards are drawn for war comparison
        if(isWar == true){
            p1Card = playCard(player1);
            p2Card = playCard(player2);
        }

        //print played cards
        print("Player 1 played: " + p1Card);
        print("Player 2 played: " + p2Card);

        //compare drawn cards
        //p1 wins if their card is not null and either p2's card is null or p1>p2
        if(p1Card != null && (p2Card == null || p1Card.getValue() > p2Card.getValue())){
            print("Player 1 wins this round.");

            //counter for number of rounds
            numRounds++;
            //add pool deck to winners hand
            player1.addCardsToPrizeDeck(poolDeck);

            //check size of hands after cards are exchanged
            print("Player 1 has " + player1.size() + " cards.");
            print("Player 2 has " + player2.size() + " cards.");

            //sets winner state to player1 to exit war state
            winner = player1;
        }

        //p2 wins if their card is not null and either p1's card is null or p2>p1
        else if(p2Card != null && (p1Card == null || p2Card.getValue() > p1Card.getValue())){
            print("Player 2 wins this round.");

            //counter for number of rounds
            numRounds++;

            //add pool deck to winners hand
            player2.addCardsToPrizeDeck(poolDeck);

            //check size of hands after cards are exchanged
            print("Player 1 has " + player1.size() + " cards.");
            print("Player 2 has " + player2.size() + " cards.");

            //sets winner state to player2 to exit war state
            winner = player2; 
        }
        //if neither p1 or p2 are larger then war is declared 
        else{
            print("This means war!");

            //counter for number of rounds
            numRounds++;
            //counter for number of wars
            numWars++;

            //sets winner to enable war state of this method
            winner = battle(player1, player2, true);
        }

        //used to see game step by step
        //new Scanner(System.in).nextLine();

        //returns the winner of each battle
        return winner;
    }

    //method for starting the game
    public void initialize(){
        //creates base deck
        Deck myDeck = new Deck(false);
        //shuffle the deck
        myDeck.shuffle();

        //create players for the game
        Player player1 = new Player();
        Player player2 = new Player();

        //populate player's decks
        while(myDeck.size() > 0){
            player1.addCardPlayerDeck(myDeck.dealCard());
            player2.addCardPlayerDeck(myDeck.dealCard());
        }

        //keeps battles going until someone wins, ending condition is one person having all 54 cards
        while (player1.size() < 54 && player2.size() < 54){
            battle(player1, player2, false);
        }

        //if player2's deck hits 0, player1 wins
        if(player2.size() == 0){
            print("Player 1 wins the game!");
            print(numRounds + " rounds played.");
            numWinsP1++;
        }

        //if player1's deck hits 0, player2 wins
        if(player1.size() == 0){
            print("Player 2 wins the game!");
            print(numRounds + " rounds played.");
            numWinsP2++;
        }
    }
    //main method
    public static void main(String[] args) {
        War wargame = new War(false);
    }
}
