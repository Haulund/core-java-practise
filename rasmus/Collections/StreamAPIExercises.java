package rasmus.Collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StreamAPIExercises {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bjarne", "Torben", "Hans", "Lone", "Ib", "Flemming", "Dorte", "Sigurd", "Ole");
        HashMap<Integer, String> idsAndNames = new HashMap<>();
        idsAndNames.put(1, "Bjarne");
        idsAndNames.put(2, "Torben");
        idsAndNames.put(3, "Hans");
        idsAndNames.put(4, "Lone");
        idsAndNames.put(5, "Ib");
        idsAndNames.put(6, "Flemming");
        idsAndNames.put(7, "Dorte");
        idsAndNames.put(8, "Sigurd");
        idsAndNames.put(9, "Ole");

        createStringFromFirstLetters(names);
        removeOddLengthWords(names);
        uppercaseWords(names);
        stringFromMap(idsAndNames);
    }

    // 5: Create a new Thread that prints the numbers from a list.


    // 4: Convert every key-value pair of a map into a string and append them all into a single string, in iteration order.
    private static void stringFromMap(HashMap<Integer, String> idsAndNames) {
        StringBuilder sb = new StringBuilder();

        idsAndNames.forEach((k, v) -> sb.append(k).append(v));

        System.out.println(sb + "\n");
    }

    // 3: Replace every word in a list with its upper case equivalent.
    private static void uppercaseWords(List<String> names) {
        List<String> uppercaseWords = names.stream().map(String::toUpperCase).toList();

        System.out.println(uppercaseWords + "\n");
    }

    // 2: Remove the words that have odd length from a list.
    private static void removeOddLengthWords(List<String> names) {
        List<String> evenList = names.stream().filter(s -> s.length()%2 == 0).toList();

        System.out.println(evenList + "\n");
    }

    // 1: Create a string that consists of the first letter of each word in a list of Strings.
    private static void createStringFromFirstLetters(List<String> names) {
        StringBuilder sb = new StringBuilder();
        
        names.stream().map(c -> c.charAt(0)).forEach(sb::append);
        
        System.out.println(sb + "\n");
    }
}
