package ExTwo;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.IntStream;


public class IntsCounter {

    public static void moreThanThree(List<Integer> intArray) {
        int numberOfIntsWithMoreThanThreeOccurrences = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        List<Integer> list = intArray.stream().sorted().distinct().toList();

        for (Integer integer : list) {
            hashMap.put(integer, 0);
        };

        intArray.stream().forEach(num -> {
            if(hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num) + 1);
            }
        });

        list.forEach(a -> System.out.print(a + " "));

        

        System.out.println(hashMap);
        
         
        


        //System.out.println("There are " + numberOfIntsWithMoreThanThreeOccurrences + " With more than three occurrances");
    }
    
}

