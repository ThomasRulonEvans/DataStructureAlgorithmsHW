//Thomas Evans
//Assignment 7
//2235 - 01
//Factory class

//import libs
import java.util.PriorityQueue;
import java.util.Random;

//define class
public class Factory {
    //initial vars
    private Random randNum = new Random();
    private Order currentOrder;
    //counter variables for ending stats
    private int numberOfOrders = 0;
    private int numberOfOrdersProcessed = 0;
    private int daysOfOperation = 0;
    private int numberOfRushes = 0;
    private int numberOfDiscounted = 0;
    private int revenue = 0;

    //Define PriorityQueue before initialization
    private PriorityQueue<Order> newQueue;

    //constructors
    //creates a new order with certain variables
    public void newRandOrder(boolean isRush, boolean isDiscounted, boolean isNew){

        //initializes the new order with the parameters set above then adds it to the queue
        Order newOrder = new Order("Order_" + (numberOfOrders + 1), isRush, isDiscounted, isNew);
        newQueue.add(newOrder);
        //counts total number of orders
        numberOfOrders++;
    }

    //populates queue using the default parameters and passing false for all modifying parameters
    public void populateQueue(int size){
        //creates a new priorityQueue using a passed size then fills with random orders
        newQueue = new PriorityQueue<Order>(size);
        while(numberOfOrders < size ){
            newRandOrder(false, false, false);
        }
    }

    //processes the orders in the Queue while keeping track of days passed and when new jobs must be made
    public void processQueue(){
        while(daysOfOperation <= 730){
            processDay();
            daysOfOperation++;
        }
    }

    public void processDay(){
        maybeGenerateOrder();
        
        //populate current order
        if(currentOrder == null){
            currentOrder = newQueue.poll();
        }
        //if the current order is complete and the queue is empty generate a new order
        if(currentOrder.isComplete()){
            currentOrderCompleted();
            if(newQueue.isEmpty()){
                newRandOrder(false, true, true);
            }
            currentOrder = newQueue.poll();
        }
        //advances work counter
        currentOrder.doWork();
    }

    //might make a new normal or rushed job
    public void maybeGenerateOrder(){
        //if to check if a new job should be a rush job or a new job
        if(daysOfOperation > 0 && daysOfOperation % 50 == 0){
            
            //50/50 output to a boolean to choose if it is a rush job
            boolean coinToss = randNum.nextInt(2) == 1;
            
            //if it is not a rush job only new is true which forces priority 20 on the order
            newRandOrder(coinToss, false, true);
        }
    }

    //keeps track of revenue and counters for end stats
    public void currentOrderCompleted(){
        revenue += currentOrder.getValue();
        if(currentOrder.isRush()){
            numberOfRushes++;
        }
        if(currentOrder.isDiscounted()){
            numberOfDiscounted++;
        }
        numberOfOrdersProcessed++;
    }

    //print statistics
    public void printStats(){ 
        System.out.println("Number of orders requested: " + numberOfOrders + ".");
        System.out.println("Number of orders processed: " + numberOfOrdersProcessed + ".");
        System.out.println("Number of rushed orders processed: " + numberOfRushes + ".");
        System.out.println("Number of discounted orders processed: " + numberOfDiscounted + ".");
        System.out.println("Amount of revenue earned: $" + revenue + ".");
    }

    public static void main(String[] args) {
        //creates factory to maintain processes
        Factory myFactory = new Factory();

        //fills the queue with initial orders
        myFactory.populateQueue(10);
        //processes the queue including checking for new modified jobs
        myFactory.processQueue();
        //prints end stats
        myFactory.printStats();
    }
}
