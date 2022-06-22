//Thomas Evans
//MidProject
//2235 - 01
//War Deck class

//import libs
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    //instance variables
    private ArrayList<Card> deck;
    
    //constructors
    public Deck(boolean emptyDeck){
        //used to make empty decks for temporary storage of cards
        if(emptyDeck == true){
            deck = new ArrayList<Card>(0);
        }

        //used to make the origin deck of 54 cards
        else{
            deck = new ArrayList<Card>(54);
            //array of strings for suits
            String[] suits = {"Clubs", "Hearts", "Diamonds", "Spades"};
            
            //card values are going to start at 2
            //this loop will add 4 cards with a different suit for each value
            for (int i = 2; i < 15; i++){
                for (var suit : suits){
                    Card card = new Card(i, suit);
                    deck.add(card);
                }
            }

            //account for the jokers we will assume a value of 15
            Card card = new Card(15, "Joker");
            deck.add(card);
            deck.add(card);
        }
    }
    
    //methods
    //check the deck of cards
    public String toString(){
        String sb = "";
        for (var card : deck){
            sb += card.getValue() + " " + card.getSuit() + "\n";
        }
        return sb;
    }

    //shuffle the deck of cards
    public void shuffle(){
        Collections.shuffle(deck);
    }

    //add card to deck
    public void addCard(Card card){
        deck.add(card);
    }

    //deal cards to be played
    public Card dealCard(){
        if (deck.size() != 0){
            return deck.remove(0);
            //removes card from the top of the deck
        }
        return null;
    }

    //check size of deck
    public int size(){
        return deck.size();
    }
}
