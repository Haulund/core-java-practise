package ExTwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashmapPrac {
    public static void main(String[] args) {
        //Hashmap to hold repated numbers(key) and how many times they are repaeted (value) 
        HashMap<Integer, Integer> repeatNumbers = new HashMap<Integer, Integer>();

        // numbers list to be counted
        List<Integer> numbers = Arrays.asList(1,1,1,1,1,1,2,2,2,3,3,3,3,3,3,3,4,5,5,5,5,5,5,5,11,11,11,11);
        
        // creating a List with keys for the hashmap
        // adding the keys to the hashmap
        numbers.stream().distinct().forEach(key -> repeatNumbers.put(key, 0));

        // adding the counts to the hashmap
        numbers.stream().forEach(num -> {
            int count = (int)numbers.stream().filter(a -> a == num).count();
            repeatNumbers.put(num, count);
        });

        // removing the entries that have less than 3
        repeatNumbers.values().removeIf(val -> val <= 3);
        
        System.out.println(repeatNumbers);
        System.out.println("there are " + repeatNumbers.size() + " numbers that is repeated more than 3 times");

    }
}

