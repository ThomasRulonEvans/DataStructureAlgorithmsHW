//Thomas Evans
//MidProject
//2235 - 01
//War Player class

//import libs
import java.util.ArrayDeque;

//declare class
public class Player {
    //instance variables
    //create deck for the player as well as a second deck to keep track of when to shuffle
    private Deck playerDeck;
    private Deck prizeDeck;

    //constructors
    public Player(){
        //makes decks for each player to keep track of hand and winnings
        playerDeck = new Deck(true);
        prizeDeck = new Deck(true);
    }

    //methods
    //used when player runs out of cards in their main hand
    //moves won cards to main deck
    private void addCardsToPlayerDeck(){
        while(prizeDeck.size() > 0){
            addCardPlayerDeck(prizeDeck.dealCard());
        }
    }

    //used when a player wins the pool
    //moves pooldeck to won cards deck
    public void addCardsToPrizeDeck(Deck deck){
        while(deck.size() > 0){
            addCardPrizeDeck(deck.dealCard());
        }
    }

    //add card to players main deck
    public void addCardPlayerDeck(Card c){
        playerDeck.addCard(c);
    }

    //add card to players won cards deck
    private void addCardPrizeDeck(Card c){
        prizeDeck.addCard(c);
    }

    //check value of decks
    public String toString(){
        return playerDeck.toString() + prizeDeck.toString();
    }

    //check size of player's deck
    public int size(){
        return playerDeck.size() + prizeDeck.size();
    }

    //deal card to be played
    //if the main deck is empty, adds the won cards to main deck and shuffles their main deck
    public Card dealCard(){
        if(playerDeck.size() == 0){
            addCardsToPlayerDeck();
            playerDeck.shuffle();
        }
        return playerDeck.dealCard();
    }
}
