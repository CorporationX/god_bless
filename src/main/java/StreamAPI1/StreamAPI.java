package StreamAPI1;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamAPI {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<String> words = Arrays.asList("cat", "dog", "catafalk", "window");

        System.out.println(sumOfEvenNumbers(numbers));
        System.out.println(getMaxValueInList(numbers));
        System.out.println(getAverageValueInList(numbers));
        System.out.println(getStringsStartingBySymbol(words, 'c'));
        containsSubstring(words, "at").forEach(System.out::println);
        sortStringListByStringsLength(words).forEach(System.out::println);
        System.out.println(checkListByCondition(numbers, x -> x > 0));
        System.out.println(checkListByCondition(words, s -> s.length() > 4));
        System.out.println(getMinIntAfterValue(numbers, 10));
        System.out.println(getLengthsOfWords(words));
    }

    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
    }

    public static int getMaxValueInList(@NonNull List<Integer> numbers) {
        return Collections.max(numbers);
    }

    public static int getAverageValueInList(@NonNull List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).sum() / numbers.size();
    }

    public static int getStringsStartingBySymbol(@NonNull List<String> words, char symbol) {
        return (int) words.stream().filter(word -> word.charAt(0) == symbol).count();
    }

    public static List<String> containsSubstring(@NonNull List<String> words, String filter) {
        return words.stream().filter(word -> word.contains(filter)).toList();
    }

    public static List<String> sortStringListByStringsLength(@NonNull List<String> words) {
        return words.stream().sorted((word1, word2) -> word1.length() - word2.length()).toList();
    }

    public static boolean checkListByCondition(@NonNull List<Integer> list, StatusCheckForInt check) {
        return list.stream().allMatch(check::check);
    }

    public static boolean checkListByCondition(@NonNull List<String> list, StatusCheckForString check) {
        return list.stream().allMatch(check::check);
    }

    public static int getMinIntAfterValue(@NonNull List<Integer> numbers, int value) {
        return numbers.stream().filter(number -> number > value).mapToInt(number -> number).min().getAsInt();
    }

    public static List<Integer> getLengthsOfWords(@NonNull List<String> words) {
        return words.stream().map(String::length).toList();
    }
}
