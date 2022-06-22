//Thomas Evans
//Assignment 7
//2235 - 01
//Order class

//import libs
import java.util.Random;

//define class
public class Order implements Comparable<Order>{
    //initial vars
    private String orderName;
    private int orderPriority;
    private int orderLength;
    private int orderValue;
    private int orderLengthCompleted = 0;
    private boolean isRush;
    private boolean isDiscounted;
    private boolean isNew;

    //constructor for order object, receives name and flags for new orders
    public Order(String name, boolean isRush, boolean isDiscounted, boolean isNew){
        this.orderName = name;
        this.isRush = isRush;
        this.isDiscounted = isDiscounted;
        this.isNew = isNew;

        //random number generator for order length
        Random randNum = new Random();
        orderLength = randNum.nextInt(41)+10;

        //default parameter order
        if(!isRush && !isDiscounted && !isNew){
            setOrderValue(25000);
            orderPriority = randNum.nextInt(20)+1;
        }

        //if isRush is ever true the priority is set to 1 and value is set to 25000*3
        if(isRush){
            orderPriority = 1;
            setOrderValue(25000*3);
        }

        //if isDiscounted is ever true the value is set to 10000
        if (isDiscounted){
            orderPriority = randNum.nextInt(20)+1;
            setOrderValue(10000);
        }

        //if only isNew is true a priority of 20 is set to the order and it is added to the end of cue
        if(!isRush && !isDiscounted && isNew){
            setOrderValue(25000);
            orderPriority = 20;
            //doesn't need a special counter since it is a normal job of low priority
        }
    }

    //checks if the current order has been completed
    public boolean isComplete(){
        return orderLength == orderLengthCompleted;
    }

    //setters
    //counter for how much work has been done on an order
    public void doWork(){
        System.out.println(this.toString());
        orderLengthCompleted++;
    }

    //adjusts order value against length
    private void setOrderValue(int value){
        orderValue = value * orderLength;
    } 

    //getters
    public String getName(){
        return orderName;
    }

    public int getPriority(){
        return orderPriority;
    }

    public int getLength(){
        return orderLength;
    }

    public int getValue(){
        return orderValue;
    }

    public boolean isRush(){
        return isRush;
    }

    public boolean isDiscounted(){
        return isDiscounted;
    }

    public boolean isNew(){
        return isNew;
    }

    public String toString(){
        return "Name: " + getName() + ". " + "Priority: " + getPriority() + ".";
    }

    //compareto for comparable
    @Override
    public int compareTo(Order orderTwo){
        if(this.getPriority() > orderTwo.getPriority()){
            return 1;
        }
        if(this.getPriority() < orderTwo.getPriority()){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
    }
}