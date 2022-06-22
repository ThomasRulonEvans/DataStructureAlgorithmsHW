//Thomas Evans
//MidProject
//2235 - 01
//War Card class

//define class
public class Card {
    //instance variables
    int value;
    String suit;

    //constructors
    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
    }

    //method
    public int getValue(){
        return value;
    }
    public String getSuit(){
        return suit;
    }
    public String toString(){
        return getValue() + " " +  getSuit();
    }
}
