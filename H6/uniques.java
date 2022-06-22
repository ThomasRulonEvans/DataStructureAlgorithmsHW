//Thomas Evans
//Assignment #6
//2235 - 01
//Scoreboard analysis

//uniques1/2
import java.lang.reflect.Array;
import java.security.Principal;
import java.util.Arrays;
import java.util.Random;

import jdk.nashorn.internal.ir.ReturnNode;

public class uniques {
    //random array generator
    public static int[] getArray(int size){
        //initialize new array
        int[] randArray = new int[size];
        //random number generator
        Random numRandom = new Random(); 
        //fill array with ints
        for (int i = 0; i < size; i++){
            randArray[i] = i;
            // \/ was used to fill array with random ints, I had to change to a linear array fill because I could not get the process to take longer than 5 seconds with the random array fill
            // randArray[i] = numRandom.nextInt(Integer.MAX_VALUE-1);
        }
        return randArray;
    }
    //test unique1 while stepping up size of array
    public static int analyzeTestUnique1(){
        int n = 0;
        int stepSize = 10000;
        //while not true increment number of array elements
        while (testUnique1(n) != true){
            n += stepSize;
        }
        return n;
    }
    
    //keeps checking time to complete until it is over 1 minute
    public static boolean testUnique1(int size){
        int[] randArray = getArray(size);
        //start time
        long time1 = System.currentTimeMillis();
        boolean result = unique1(randArray);
        //end time
        long time2 = System.currentTimeMillis();
        //print time to screen and calculate if the process took more than a minute
        System.out.println("Size " + size + " took " + (time2-time1) + "ms.");
        boolean moreThanOneMinute = (time2 - time1) >= 60000;
        return moreThanOneMinute;
    }

    //returns true if there are no duplicate elements in the array
    public static boolean unique1(int[] data){
        int n = data.length;
        for (int j = 0; j < n - 1; j++){
            for (int k = j + 1; k < n; k++){
                if (data[j] == data[k]){
                    return false;
                }
            } 
        }
        return true;
    }
    //test unique2 while stepping up size of array
    public static int analyzeTestUnique2(){
        int n = 0;
        int stepSize = 10000;
        //while not true increment number of array elements
        while (testUnique2(n) != true){
            n += stepSize;
        }
        return n;
    }

    //keeps checking time to complete until it is over 1 minute
    public static boolean testUnique2(int size){
        int[] randArray = getArray(size);
        //start time
        long time1 = System.currentTimeMillis();
        boolean result = unique2(randArray);
        //end time
        long time2 = System.currentTimeMillis();
        //print time to screen and calculate if the process took more than a minute
        System.out.println("Size " + size + " took " + (time2-time1) + "ms.");
        boolean moreThanOneMinute = (time2 - time1) >= 60000;
        return moreThanOneMinute;
    }

    //returns true if there are no duplicate elements in the array
    public static boolean unique2(int[] data){
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);
        Arrays.sort(temp);
        for (int j = 0; j < n - 1; j++){
            if (temp[j] == temp[j+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(analyzeTestUnique1());
        System.out.println(analyzeTestUnique2());
    }
}