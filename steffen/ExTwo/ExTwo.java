package ExTwo;
/*
 *  1.Count letters of a word
    2. first occorrence of a letter used 2 times in a word
    3. Array of ints -> how many int are there more than 3 times.
    4. List of ints -> who has a adjacent value higher than it self.
    5. sum of squared odd numbers in list
    6. filter even numbers
    7. print x everytime a number is divideble with 6 and 5
 */

import java.util.Arrays;
import java.util.List;

public class ExTwo {
    public static void main(String[] args) {
        // count letters of a word
        LetterCounter.letterCountExcersize("sampleWords");
        
        // 2. first occorrence of a letter used 2 times in a word
        StringAnalyser.firstOccurrenceExcersize("nrrsaki");

        List<Integer> intArray = Arrays.asList(1,2,3,45,5,2,12,43,2,1,2334,4,56,6,43,32,2,2,3,4,5,6,34,2,24,5,65,67,5,43,2,2,11,1,2334,54,56,76,3,3,33);
        //3. Array of ints
        IntsCounter.moreThanThree(intArray);
    }
}
