package rasmus.Collections2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class IntegerCollectionExercises {
    public static int[] numbers = {1, 2, 5, 2, -1, 2, 4, 5, 2, 4, 5, 3, 5, 2, -1, 1, 3, 1, -2, 10, 12, 11, 14, 15, 10, 12, 18, 30};
    public static List<Integer> numbersList = Arrays.asList(1, 2, 5, 2, -1, 2, 4, 5, 2, 4, 5, 3, 5, 2, -1, 1, 3, 1, -2, 10, 12, 11, 14, 15, 10, 12, 18, 30);

    public static void main(String[] args) {

        sortArrayAscending(numbers);
        sortListAscending(numbersList);
        moreThanThreeTimesInArray(numbers);
        moreThanThreeTimesInList(numbersList);
        largerAdjacentValue(numbers);
    }

    // 4. List of ints -> who has an adjacent value higher than itself.
    private static void largerAdjacentValue(int[] numbers) {
        int[] newNumbers = IntStream.range(0, numbers.length - 1)
                .filter(i -> numbers[i] < numbers[i + 1])
                .map(i -> numbers[i])
                .toArray();

        System.out.println(Arrays.toString(newNumbers) + "\n");
    }

    // 3. Array of ints -> how many int are there more than 3 times.
    private static void moreThanThreeTimesInList(List<Integer> numbersList) {
        HashMap<Integer, Integer> numbersAndCount = new HashMap<>();

        numbersList.stream().distinct().forEach(k -> numbersAndCount.put(k, 0));

        numbersList.forEach(key ->
                numbersAndCount.put(key, (int) numbersList.stream()
                        .filter(num -> Objects.equals(num, key))
                        .count()));

        numbersAndCount.values().removeIf(v -> v < 4);

        numbersAndCount.forEach((key, value) -> System.out.println(key + " occurrences more than 3 times (" + value + " times)"));
        System.out.println();
    }


    // 3. Array of ints -> how many int are there more than 3 times.
    private static void moreThanThreeTimesInArray(int[] numbers) {
        HashMap<Integer, Integer> numbersAndCount = new HashMap<>();

        Arrays.stream(numbers).distinct().forEach(n -> numbersAndCount.put(n, 0));

        Arrays.stream(numbers)
                .forEach(key ->
                        numbersAndCount.put(key, (int) Arrays.stream(numbers)
                                .filter(num -> num == key)
                                .count()));

        numbersAndCount.values().removeIf(v -> v < 4);

        numbersAndCount.forEach((key, value) -> System.out.println(key + " occurrences more than 3 times (" + value + " times)"));
        System.out.println();
    }

    private static void sortListAscending(List<Integer> numbersList) {
        List<Integer> sortedList = numbersList.stream().sorted().toList();

        System.out.println(sortedList + "\n");
    }

    private static void sortArrayAscending(int[] numbers) {
        int[] sortedArray = Arrays.stream(numbers).sorted().toArray();

        System.out.println(Arrays.toString(sortedArray) + "\n");
    }
}
