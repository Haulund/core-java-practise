package rasmus.Collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StringCollectionExercises {
    public static void main(String[] args) {
        String[] names = {"Bjarne", "Torben", "Hans", "Lone", "Ib", "Flemming", "Dorte", "Sigurd", "Ole"};

        sortStringArray(names);
        countLettersOfWords("Biblioteket er lukket i dag");
        firstLetterToOccurrenceTwoTimesInWord("Døende");
        sortBasedOnFourthLetterRemoveIfLess(names);
    }

    // 1. sort an array of strings based on 4th letter, if there are less than for letters remove word from array
    private static void sortBasedOnFourthLetterRemoveIfLess(String[] names) {
        String[] namesLongerThanThree = Arrays.stream(names).filter(n -> n.length() > 3).toArray(String[]::new);

        Arrays.sort(namesLongerThanThree, Comparator.comparingInt(s -> s.charAt(3)));

        System.out.println("Sorted String array by fourth character: " + Arrays.toString(namesLongerThanThree) + "\n");
    }

    // 2. first occurrence of a letter used 2 times in a word
    private static void firstLetterToOccurrenceTwoTimesInWord(String word) {
        OptionalInt index = IntStream.range(0, word.length())
                .filter(i -> IntStream.range(i + 1, word.length())
                        .filter(j -> word.toLowerCase().charAt(i) == word.toLowerCase().charAt(j))
                        .findFirst()
                        .isPresent()
                )
                .findAny();

        index.ifPresent(letter -> System.out.println("'" + word.toLowerCase().charAt(index.getAsInt()) + "' is the first letter to occurrence 2 times\n"));
    }


    // 2. first occurrence of a letter used 2 times in a word
//    private static void firstLetterToOccurrenceTwoTimesInWord(String word) {
//        HashMap<Character, Integer> lettersAndCount = new HashMap<>();
//        char[] letters = word.toLowerCase().toCharArray();
//
//        // TODO Found on StackOverflow. Get an understanding
////        HashMap<String, Long> lettersAndCount = (HashMap<String, Long>) Arrays.stream(word.split("")) // Stream String
////                .map(String::toLowerCase) // All letters to lower case
////                .filter(letter -> !letter.equals(" ")) // Remove spaces
////                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        for (char letter : letters) {
//            if (!lettersAndCount.containsKey(letter)) {
//                lettersAndCount.put(letter, 1);
//            } else {
//                lettersAndCount.put(letter, lettersAndCount.get(letter) + 1);
//            }
//        }
//
//        lettersAndCount.values().removeIf(v -> v != 2);
//
//        // Prints all
////        lettersAndCount.forEach((key, value) -> System.out.println("'" + key + "' occurrences " + value + " times"));
//
//        // With help from StackOverflow
//        Optional<Character> firstLetter = lettersAndCount.keySet().stream().findFirst();
//        firstLetter.ifPresent(letter -> System.out.println("'" + letter + "' is the first letter to occurrence 2 times\n"));
//    }

    // 1. Count letters of a word
    private static void countLettersOfWords(String words) {
        String [] allWords = words.split(" ");

        for (String word : allWords) {
            int letters = word.length();
            System.out.println("Amount of letters in '" + word + "': " + letters);
        }
        System.out.println();
    }

    // 1. sort an array of Strings alphabetically
    private static void sortStringArray(String[] names) {
        // TODO read up on method reference operator
        String[] sortedNames = Arrays.stream(names).sorted().toArray(String[]::new);

        System.out.println("Sorted String array: " + Arrays.toString(sortedNames) + "\n");
    }


}
