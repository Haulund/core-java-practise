package ExTwo;

import java.util.stream.IntStream;

public class StringAnalyser {

    public static void firstOccurrenceExcersize(String string) {      
        int index = IntStream.range(0, string.length())
            .filter(i -> IntStream.range(i+1, string.length())
                    .filter(j -> string.toLowerCase().charAt(i) == string.toLowerCase().charAt(j)).findFirst().isPresent()
                    )
            .findFirst()
            .getAsInt();

        System.out.println("an index: " + index);
    }
    
}
