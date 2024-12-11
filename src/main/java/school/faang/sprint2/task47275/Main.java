package school.faang.sprint2.task47275;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.asList(0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11);

        int result1 = StreamFunc.sumOfEventNumbers(numbers1);
        System.out.println("Sum of event numbers: " + result1);

        int result2 = StreamFunc.maxOfNumbers(numbers1);
        System.out.println("Max number: " + result2);

        double result3 = StreamFunc.averageOfNumbers(numbers1);
        System.out.println("Average of numbers: " + result3);

        List<String> strings = Arrays.asList("Strong", "String", "Struggle", "Stout",
                "Survivor", "Apple", "Book", "Tree", "Bed", "Sun", "Pig");

        char prefixChar = 'S';
        long result4 = StreamFunc.numOfStringsByMask(strings, prefixChar);
        System.out.println("Qty of string begins of " + prefixChar + ": " + result4);

        String mask = "tr";
        List<String> result5 = StreamFunc.numOfStringsByMask(strings, mask);
        System.out.println("All strings with mask *" + mask + "*" + result5);

        List<String> result6 = StreamFunc.sortStringsByLength(strings);
        System.out.println("Sorted strings by length" + result6);

        int threshold = 5;
        boolean result7 = StreamFunc.checkNumbers(numbers1, (i) -> i > threshold);
        System.out.println("All numbers greater than " + threshold + ":" + result7);

        int thresholdZero = 0;
        boolean result8 = StreamFunc.checkNumbers(numbers1, (i) -> i >= thresholdZero);
        System.out.println("All numbers greater than or equals " + thresholdZero + ":" + result8);

        int minNumber = 2;
        int result9 = StreamFunc.getMinNumber(numbers1, minNumber);
        System.out.println("Min number greater than " + minNumber + ":" + result9);

        List<Integer> result10 = StreamFunc.getStringListLengths(strings);
        System.out.println("Length of strings:" + result10);

    }
}