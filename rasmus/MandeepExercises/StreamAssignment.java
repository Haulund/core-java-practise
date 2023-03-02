package rasmus.MandeepExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAssignment {
    public static void main(String[] args) throws IOException {

        listTop10MostUsedWords();
    }

    /**
     * The programming exercise is to create a Java program that counts unique words from a text file
     * and list the top 10 occurrences.
     * Using the supplied text file (stream.txt), English locale and treating hyphen and apostrophe as part of a
     * word, it should give the following output
     */
    private static void listTop10MostUsedWords() throws IOException {
        Map<String, Long> wordsAndCount =
                // Read text file from given path to a List of Strings
                Files.readAllLines(Path.of("rasmus/MandeepExercises/stream.txt"))
                // Stream List of Strings
                .stream()
                // Map to a flattened List of Strings where special characters are removed and the Strings split by whitespace and lower cased
                .flatMap(s -> Arrays.stream(s.replaceAll("[\"?!.,:;()\\[\\]{}]", "").toLowerCase().split(" ")))
                // Collect to a Map where the key is the String and value is the number of times the String is used
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        System.out.println("Top 10 used words:");

        wordsAndCount
                // Get EntrySet of wordsAndCount Map
                .entrySet()
                // Stream EntrySet
                .stream()
                // Sort entries by the Long values and reverse the order
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                // Limit the output to 10 entries
                .limit(10)
                // Print entries
                .forEach(e -> System.out.println("'" + e.getKey() + "' is used " + e.getValue() + " times"));
    }




    /*
        Map<String, Long> wordsAndCount = Files.readAllLines(Paths.get("rasmus/MandeepExercises/stream.txt"))
                .stream()
                .flatMap(s -> Arrays.stream(s.replaceAll("[^a-zA-Z'\\-]", " ").toLowerCase().split("\\s+")))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        System.out.println("10 most used words:");
        wordsAndCount.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println("'" + e.getKey() + "' is used " + e.getValue() + " times"));
     */
}
