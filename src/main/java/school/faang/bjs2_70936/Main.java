package school.faang.bjs2_70936;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        testSumOfNumber();
        testSortCapitals();
        testSortedByLengthWithLetter();
        testToBinary();
        testSortAlphabeticallyThenByLength();
    }

    public static void testSumOfNumber() {
        System.out.println("Testing sumOfNumber...");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int target = 6;

        List<int[]> result = ListOperations.sumOfNumber(numbers, target);

        System.out.println("Input: " + numbers + ", target: " + target);
        System.out.print("Output: [");
        for (int i = 0; i < result.size(); i++) {
            int[] pair = result.get(i);
            System.out.print("(" + pair[0] + ", " + pair[1] + ")");
            if (i < result.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println();
    }

    public static void testSortCapitals() {
        System.out.println("Testing sortCapitals...");
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        List<String> result = ListOperations.sortCapitals(countries);

        System.out.println("Input: " + countries);
        System.out.println("Output: " + result);
        System.out.println();
    }

    public static void testSortedByLengthWithLetter() {
        System.out.println("Testing sortedByLengthWithLetter...");
        List<String> words = List.of("apple", "banana", "avocado", "apricot");
        char letter = 'a';

        List<String> result = ListOperations.sortedByLengthWithLetter(words, letter);

        System.out.println("Input: " + words + ", letter: '" + letter + "'");
        System.out.println("Output: " + result);
        System.out.println();
    }

    public static void testToBinary() {
        System.out.println("Testing toBinary...");
        List<Integer> numbers = List.of(1, 2, 3, 4);

        List<String> result = ListOperations.toBinary(numbers);

        System.out.println("Input: " + numbers);
        System.out.println("Output: " + result);
        System.out.println();
    }

    public static void testSortAlphabeticallyThenByLength() {
        System.out.println("Testing sortAlphabeticallyThenByLength...");
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> result = ListOperations.sortAlphabeticallyThenByLength(words, alphabet);

        System.out.println("Input: " + words + ", alphabet: \"" + alphabet + "\"");
        System.out.println("Output: " + result);
        System.out.println();
    }
}
