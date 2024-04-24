package faang.school.godbless.stream.BJS2_5836;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 7, 8, 9, 10);
        List<String> strings = List.of("three", "one", "two", "two three");

        System.out.println("Even numbers sum = " + getSumOfEvenNumbers(numbers));
        System.out.println("Max = " + getMaxNumber(numbers));
        System.out.println("Average = " + getAverage(numbers));
        System.out.println("Count of strings in the list starting with t = " + countStringsStartingWith(strings, "t"));
        System.out.println("Filter strings from List containing 'two': " + filterWordsContainSubstring(strings, "two"));
        System.out.println("Sort string list by string length: " + sortListByStringLength(strings));
        System.out.println("All numbers < 11 = " + testAllElements(numbers, n -> n < 11));
        System.out.println("Find min element > 3 = " + getMinNumberAndMoreThen(numbers, 3));
        System.out.println("Get list of length: " + getListOfLength(strings));
    }

    public static int getSumOfEvenNumbers(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Invalid value: " + numbers);
        }

        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int getMaxNumber(List<Integer> numbers) {
        checkList(numbers);

        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Empty"));
    }

    public static double getAverage(List<Integer> numbers) {
        checkList(numbers);

        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new RuntimeException("Empty"));
    }

    public static long countStringsStartingWith(List<String> strings, String letter) {
        checkList(strings);

        return strings.stream()
                .filter(s -> s.startsWith(letter))
                .count();
    }

    private static List<String> filterWordsContainSubstring(List<String> words, String substring) {
        checkList(words);

        return words.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    private static List<String> sortListByStringLength(List<String> words) {
        checkList(words);

        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static boolean testAllElements(List<Integer> numbers, Predicate<Integer> condition) {
        checkList(numbers);

        return numbers.stream().allMatch(condition);
    }

    public static int getMinNumberAndMoreThen(List<Integer> numbers, Integer moreNumber) {
        checkList(numbers);

        return numbers.stream()
                .filter(n -> n > moreNumber)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Empty"));
    }

    private static List<Integer> getListOfLength(List<String> words) {
        checkList(words);

        return words.stream()
                .map(String::length)
                .toList();
    }

    public static <T> void checkList(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Invalid value: " + list);
        }
    }
}
