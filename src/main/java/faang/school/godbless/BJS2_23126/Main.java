package faang.school.godbless.BJS2_23126;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("asteroid", "archer", "coin", "dawn", "era", "fridge", "main", "main value", "main class");

        System.out.println("Even numbers sum: " + getEvenNumberSum(numbers));

        System.out.println("Max number: " + getMaxNumber(numbers));

        System.out.println("Average number: " + getAverageNumber(numbers));

        System.out.println("Count of words started with a: " + countStartedWith(words, 'a'));

        System.out.println("List of words: " + filterWordsBySubstring(words, "main"));

        System.out.println("List of sorted words: " + sortWordsByLength(words));

        System.out.println("Is all words contains a?: " + checkListWithCondition(words, word -> word.contains("a")));

        System.out.println("Min number bigger than 4: " + getMinNumber(numbers, 4));

        System.out.println("Length of words: " + getLengthOfWords(words));
    }

    public static int getEvenNumberSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static double getAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static int countStartedWith(List<String> words, char prefix) {
        checkList(words);
        return (int) words.stream()
                .filter(word -> word.charAt(0) == prefix)
                .count();
    }

    public static List<String> filterWordsBySubstring(List<String> words, String substring) {
        checkList(words);
        return words.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> sortWordsByLength(List<String> words) {
        checkList(words);
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkListWithCondition(List<String> words, Predicate<String> predicate) {
        checkList(words);
        return words.stream()
                .allMatch(predicate);
    }

    public static int getMinNumber(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(number -> number > value)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static List<Integer> getLengthOfWords(List<String> words) {
        checkList(words);
        return words.stream()
                .map(String::length)
                .toList();
    }


    public static <T> void checkList(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }

}
