package ExOne;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ExOne
 * 1. sort an array of strings, numbers and objects
        - Strings: alphabetical
        - Numbers: Ascending
        - Objects: by a String field value
 */
public class ExOne {
    public static void main(String[] args) {
        // basic array of strings
        System.out.println("\n\nString array");
        String[] names = {"luke", "leia", "han", "chewie", "anakin", "windu"};
        List<String> result = Arrays.asList(names).stream().sorted(Comparator.reverseOrder()).toList();
        result.forEach(a -> System.out.print(a + ", "));
        

        //Numbers
        System.out.println("\n\nNumbers Array:");
        int[] numbers = {1,5,23,67,3,5,2,2,43,56,7};
        List<Integer> numbersSorted = IntStream.of(numbers).sorted().mapToObj(Integer::valueOf).toList();
        //with a deprecated
        //List<Integer> numbersSorted = IntStream.of(numbers).sorted().mapToObj(Integer::new).toList();
        numbersSorted.forEach(num -> System.out.print(num + " "));

        //Pojo by name
        System.out.println("\n\nPOJO List:");
        List<Person> persons = Arrays.asList(
            new Person("luke", 80),
            new Person("leia", 76),
            new Person("lando", 203)
        );

        List<Person> personsSorted = persons.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).toList();        
        personsSorted.forEach(obj -> System.out.println(obj.getName()));
    }
};

