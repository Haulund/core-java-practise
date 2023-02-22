package rasmus.Collections2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StringCollectionExercises {
    public static String[] names = {"Bjarne", "Torben", "Hans", "Lone", "Ib", "Flemming", "Dorte", "Sigurd", "Ole"};
    public static List<String> nameList = Arrays.asList("Bjarne", "Torben", "Hans", "Lone", "Ib", "Flemming", "Dorte", "Sigurd", "Ole");
    public static void main(String[] args) {

        sortArrayAlphabetically(names);
        countCharactersInWord("Friluftsbad");
        firstOccurrenceOfSameCharacter("Friluftsbad");
        sortBasedOnFourthCharacterRemoveIfLessThanThree(names);
        stringFromFirstLetters(nameList);
        removeWordIfOddLength(nameList);
        upperCaseAllWords(nameList);
    }

    // 3: Replace every word in a list with its upper case equivalent.
    private static void upperCaseAllWords(List<String> nameList) {
        nameList = nameList.stream().map(String::toUpperCase).toList();

        System.out.println(nameList + "\n");
    }

    // 2: Remove the words that have odd length from a list.
    private static void removeWordIfOddLength(List<String> nameList) {
        nameList = nameList.stream().filter(c -> c.length()%2 == 0).toList();

        System.out.println(nameList + "\n");
    }

    // 1: Create a string that consists of the first letter of each word in a list of Strings.
    private static void stringFromFirstLetters(List<String> nameList) {
        StringBuilder sb = new StringBuilder();
        nameList.stream().map(c -> c.charAt(0)).forEach(sb::append);

        System.out.println(sb + "\n");
    }

    // 1. sort an array of strings based on 4th letter, if there are less than for letters remove word from array
    private static void sortBasedOnFourthCharacterRemoveIfLessThanThree(String[] names) {
        Arrays.stream(names)
                .filter(c -> c.length() > 3)
                .sorted(Comparator.comparing(c -> c.charAt(3)))
                .forEach(System.out::println);

        System.out.println();
    }

    // 2. first occurrence of a letter used 2 times in a word
    private static void firstOccurrenceOfSameCharacter(String word) {
        OptionalInt index = IntStream.range(0, word.length())
                .filter(i -> IntStream.range(i + 1, word.length())
                        .filter(j -> word.toLowerCase().charAt(i) == word.toLowerCase().charAt(j))
                        .findFirst()
                        .isPresent())
                .findFirst();

        if (index.isPresent()) {
            System.out.println("'" + word.charAt(index.getAsInt()) + "' is the first character to occur two times\n");
        } else {
            System.out.println("There are no characters occurring two times\n");
        }
    }

    // 1. Count letters of a word
    private static void countCharactersInWord(String word) {
        System.out.println("'" + word + "' is " + word.length() + " characters\n");
    }

    // 1. sort an array of strings, numbers and objects - Strings: alphabetical
    private static void sortArrayAlphabetically(String[] names) {
        Arrays.sort(names);
        System.out.println(Arrays.toString(names) + "\n");
    }


}
