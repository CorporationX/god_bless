package school.faang.streamapi1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(20, 36, 43, 51, 67, 12);
        List<String> strings = List.of("abc", "_kweabd", "rfv tgb ab", "ertdfg", " abdjr", "_jhj");
        char startChar = '_';
        String subString = "ab";

        int sumEvenNumbers = ListOperations.sumOfEvenNumbers(numbers);
        System.out.println("Sum of even numbers: " + sumEvenNumbers);

        System.out.println("Max number: " + ListOperations.findMax(numbers));
        System.out.println("Average: " + ListOperations.findAverage(numbers));

        System.out.println(new StringBuilder().append("Number of lines starting with the character '")
                .append(startChar)
                .append("' - ")
                .append(ListOperations.countStringsStartingWith(strings, startChar)));

        System.out.println("Filter by subString: " + ListOperations
                .filterStringsContainingSubstring(strings, subString));
        System.out.println("Sort by length: " + ListOperations.sortByLength(strings));
        System.out.println("Are all numbers even? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Minimum number greater than 45: " + ListOperations.findMinGreaterThan(numbers, 45));
        System.out.println("String lengths: " + ListOperations.convertToLengths(strings));

    }
}
