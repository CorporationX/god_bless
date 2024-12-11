package school.faang.sprint2.task47275;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.asList(0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11);
        int result1 = StreamFunc.sumOfEventNumbers(numbers1);

        System.out.println("Sum of event numbers: " + result1);

        int result2 = StreamFunc.maxOfNumbers(numbers1);
        System.out.println("Max number: " + result2);

        double result3 = StreamFunc.averageOfNumbers(numbers1);
        System.out.println("Average of numbers: " + result3);

        List<String> strings = Arrays.asList("Strong", "String", "Struggle", "Stout", "Survivor", "Apple", "Book", "Tree", "Bed", "Sun", "Pig");

        char prefixChar = 'S';
        long result4 = StreamFunc.numOfStringsByMask(strings, prefixChar);
        System.out.println("Qty of string begins of " + prefixChar + ": " + result4);

        List<String> result5 = StreamFunc.numOfStringsByMask(strings, "tr");
        System.out.println(result5);

        List<String> result6 = StreamFunc.sortStringsByLength(strings);
        System.out.println(result6);

        IntPredicate predicate1 = (i) -> {
            if (i > 5) {
                return true;
            } else {
                return false;
            }
        };
        IntPredicate predicate2 = (i) -> {
            if (i >= 0) {
                return true;
            } else {
                return false;
            }
        };

        boolean result7 = StreamFunc.checkNumbers(numbers1, predicate1);
        System.out.println(result7);

        boolean result8 = StreamFunc.checkNumbers(numbers1, predicate2);
        System.out.println(result8);

        int result9 = StreamFunc.getMinNumber(numbers1, 2);
        System.out.println(result9);

        List<Integer> result10 = StreamFunc.getStringListLengths(strings);
        System.out.println(result10);

    }
}