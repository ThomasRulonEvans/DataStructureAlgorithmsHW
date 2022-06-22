//Thomas Evans
//Assignment 8
//2235 - 01
//word frequency

//import libs
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class WordCounter implements Comparator<Entry<String, Integer>>{

    //create comparator for sorting the has map
    public int compare(Entry<String, Integer> entryOne, Entry<String, Integer> entryTwo){
        return entryTwo.getValue() - entryOne.getValue();
    }
    
    //method for counting the words in the initial hashMap
    public Map<String, Integer> countWords() throws FileNotFoundException{
        //scanner to read contents of Jobs.txt
        Scanner scanner = new Scanner(new FileInputStream("Jobs.txt"));
        //delimiter params to exclude all nonletter chars
        scanner.useDelimiter("[^a-zA-Z]+");

        //instantiate hashmap to store words and counts
        Map<String, Integer> counterMap = new HashMap<>();

        //while loop to progress through Jobs.txt until there are no next items
        while(scanner.hasNext()){
            //String to hold the word while it is inspected
            String word = scanner.next().toLowerCase();

            //if word is present in the map increase count
            if(counterMap.containsKey(word)){
                counterMap.put(word, counterMap.get(word) + 1);
            }
            //if not then it is added as a new entry
            else{
                counterMap.put(word, 1);
            }
        }

        //label for unsorted list
        System.out.println("Unsorted:");

        //iterate over each entry in the entry set for the map storing words/values
        for(Entry<String, Integer> entry: counterMap.entrySet()){
            //print each entry's word and value
            System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
        }

        //returns the counted words
        return counterMap;
    }

    //sort function that calls a comparator
    public LinkedList<Entry<String, Integer>> sort(Map<String, Integer> map) {
        //linked list to hold freshly sorted hash map entries
        LinkedList<Entry<String, Integer>> sortedMap = new LinkedList<Entry<String, Integer>>(map.entrySet());
        //calls collections sort to sort the new list
        Collections.sort(sortedMap, this);

        //label for sorted list
        System.out.println("Sorted:");

        //iterates over each entry in the sorted list and prints them 
        for(Entry<String, Integer> entry : sortedMap){
            System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
        }

        return sortedMap;
    }

    public static void main(String[] args) throws Exception{

        //calls methods
        WordCounter counter = new WordCounter();
        Map<String, Integer> result = counter.countWords();
        counter.sort(result);
    }
}