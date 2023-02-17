package rasmus.Collections;

import java.util.HashMap;
import java.util.Optional;

public class HashMapExercises {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2345);
        hashMap.put(2, 42315);
        hashMap.put(3, 23);
        hashMap.put(4, 85);
        hashMap.put(5, 4568);
        hashMap.put(6, 843);
        hashMap.put(7, 3);
        hashMap.put(8, 567);
        hashMap.put(9, 7532);

        copyHashMap(hashMap);
        sumOfAllSquaredValuesInMap(hashMap);
    }

    // 1. Copy all the mappings from one HashMap to another.
    private static void copyHashMap(HashMap<Integer, Integer> hashMap) {
        HashMap<Integer, Integer> newHashMap = new HashMap<>(hashMap);

        System.out.println(newHashMap + "\n");
    }

    // 2. Get the square of all values in a HashMap<Integer, Integer> and get the sum.
    private static void sumOfAllSquaredValuesInMap(HashMap<Integer, Integer> hashMap) {
        Optional<Integer> squareValues = hashMap.values().stream().map(v -> v*v).reduce(Integer::sum);

        System.out.println(squareValues.orElse(null) + "\n");
    }
}
