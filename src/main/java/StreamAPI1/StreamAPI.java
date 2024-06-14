package StreamAPI1;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamAPI {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<String> words = Arrays.asList("cat", "dog", "catafalk", "window");

        System.out.println(sumPositive(numbers));
        System.out.println(max(numbers));
        System.out.println(avg(numbers));
        System.out.println(searchStringsBySymbol(words, "c"));
        filterWords(words, "at").forEach(System.out::println);
        sortByLength(words).forEach(System.out::println);
        System.out.println(ñheckListByCondition(numbers, x -> x > 0));
        System.out.println(ñheckListByCondition(words, s -> s.length() > 4));
        System.out.println(searchMinIntOnValue(numbers, 10));
        System.out.println(wordsOnLength(words));
    }

    public static int sumPositive(@NonNull List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
    }

    public static int max(@NonNull List<Integer> numbers) {
        return Collections.max(numbers);
    }

    public static int avg(@NonNull List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).sum() / numbers.size();
    }

    public static int searchStringsBySymbol(List<String> words, String symbol) {
        return (int) words.stream().filter(word -> word.substring(0, 1).equals(symbol)).count();
    }

    public static List<String> filterWords(List<String> words, String filter) {
        return words.stream().filter(word -> word.contains(filter)).toList();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream().sorted((word1, word2) -> word1.length() - word2.length()).toList();
    }

    public static boolean ñheckListByCondition(List<Integer> list, StatusCheckForInt check) {
        return list.stream().allMatch(check::check);
    }

    public static boolean ñheckListByCondition(List<String> list, StatusCheckForString check) {
        return list.stream().allMatch(check::check);
    }

    public static int searchMinIntOnValue(List<Integer> numbers, int value) {
        return numbers.stream().filter(number -> number > value).mapToInt(number -> number).min().getAsInt();
    }

    public static List<Integer> wordsOnLength(List<String> words) {
        return words.stream().map(String::length).toList();
    }
}
