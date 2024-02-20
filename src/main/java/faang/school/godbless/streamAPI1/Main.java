package faang.school.godbless.streamAPI1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] words = {"Java", "Google", "Uber", "Oracle", "Meta", "JavaScript", "Junior", "Not a Java"};
        System.out.println("sum of even numbers = " + sumOfEven(numbers));
        System.out.println("max in numbers = " + max(numbers));
        System.out.println("average in numbers = " + avg(numbers));
        System.out.println("count of words starting with 'J' = " + countWordsStartingWith(words,'J'));
        System.out.println("words containing \"Java\" are:");
        streamOfWordsContaining(words, "Java").forEach(System.out::println);
        System.out.println("words, sorted by length:");
        streamOfWordsSortedByLength(words).forEach(System.out::println);
        System.out.println("all strings matches predicate: " + allMatches(words, word -> word.toString().length() > 3));
        System.out.println("minimal element greater than 5: " + findMinimalGreatherThan(numbers, 5));
        List<Integer> wordsLength = getLengthOfWords(words);
        System.out.println(wordsLength);
    }

    private static List<Integer> getLengthOfWords(String[] words) {
        return Arrays.stream(words).map(String :: length).collect(Collectors.toList());
    }

    private static int findMinimalGreatherThan(int[] numbers, int min) {
        return Arrays.stream(numbers)
                .filter(number -> number > min)
                .min().orElse(0);
    }

    private static boolean allMatches(String[] words, Predicate condition) {
        return Arrays.stream(words).allMatch(condition);
    }

    private static Stream<String> streamOfWordsSortedByLength(String[] words) {
        return Arrays.stream(words).sorted(Comparator.comparing(word -> word.length()));
    }

    private static Stream<String> streamOfWordsContaining(String[] words, String subString) {
        return Arrays.stream(words).filter(word -> word.contains(subString));
    }

    private static int countWordsStartingWith(String[] words, char ch) {
        return (int) Arrays.stream(words).filter(word -> word.charAt(0) == ch)
                .count();
    }

    private static Double avg(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0.0);
    }

    private static int max(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }

    private static int sumOfEven(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }
}
