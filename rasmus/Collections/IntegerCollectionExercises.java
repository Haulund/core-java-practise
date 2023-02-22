package rasmus.Collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class IntegerCollectionExercises {
    public static List<Integer> numbersList = Arrays.asList(1, 2, 5, 2, -1, 2, 4, 5, 2, 4, 5, 3, 5, 2, -1, 1, 3, 1, -2, 10, 12, 11, 14, 15, 10, 12, 18, 30);
    public static int[] numbers = {1, 2, 5, 2, -1, 2, 4, 5, 2, 4, 5, 3, 5, 2, -1, 1, 3, 1, -2, 10, 12, 11, 14, 15, 10, 12, 18, 30};

    public static void main(String[] args) {

        sortNumbersAscending(numbers);
        moreThanThreeOccurrences(numbers);
        adjacentValueHigherThanSelf(numbersList);
        sumOfSquareOddNumbers(numbersList);
        filterEvenNumbers(numbersList);
        dividableByFiveAndSix(numbersList);
    }

    // 7. print x everytime a number is dividable with 6 and 5
    private static void dividableByFiveAndSix(List<Integer> numbersList) {
        for (int number : numbersList) {
            if (number%5 == 0 && number%6 == 0) {
                System.out.println("x - number " + number + " is dividable by 5 and 6");
            } else if (number%6 == 0) {
                System.out.println("x - number " + number + " is dividable by 6");
            } else if (number%5 == 0) {
                System.out.println("x - number " + number + " is dividable by 5");
            }
        }
        System.out.println();
    }

    // 6. filter even numbers
    private static void filterEvenNumbers(List<Integer> numbersList) {
        List<Integer> evenNumbersList = numbersList.stream()
                .filter(n -> n%2 == 0)
                .toList();

        System.out.println(evenNumbersList + "\n");
    }

    // 5. sum of squared odd numbers in list
    private static void sumOfSquareOddNumbers(List<Integer> numbersList) {
        Optional<Integer> optionalSum = numbersList.stream()
                .filter(n -> n%2 != 0)
                .map(n -> (int) Math.pow(n, 2))
                .reduce(Integer::sum);

        optionalSum.ifPresent(sum -> System.out.println("The sum of squared odd numbers in list is: " + sum + "\n"));
    }

    // 4. List of ints -> who has an adjacent value higher than itself.
    private static void adjacentValueHigherThanSelf(List<Integer> numbersList) {
        // TODO Read up in mapToObj
        List<Integer> higherThanList = IntStream.range(0, numbersList.size() - 1)
                .filter(i -> numbersList.get(i) < numbersList.get(i + 1))
                .mapToObj(numbersList::get).toList();

        System.out.println(higherThanList + "\n");
    }

    // 3. Array of ints -> how many int are there more than 3 times.
    private static void moreThanThreeOccurrences(int[] numbers) {
        HashMap<Integer, Integer> numbersAndOccurrences = new HashMap<>();

        for (int number : numbers) {
            if (!numbersAndOccurrences.containsKey(number)) {
                numbersAndOccurrences.put(number, 1);
            } else {
                numbersAndOccurrences.put(number, numbersAndOccurrences.get(number) + 1);
            }
        }

        numbersAndOccurrences.values().removeIf(v -> v < 4);

        numbersAndOccurrences.forEach((key, value) -> System.out.println(key + " occurrences more than 3 times (" + value + " times)\n"));
    }

    // 1. sort an array of int ascending
    private static void sortNumbersAscending(int[] numbers) {
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers) +  "\n");
    }
}
