package school.faang.godbless.bjs2_35493;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;


public class WordsManager {
    public static int countStartsWith(@NotNull List<String> words, char symbol) {
        return (int) words.stream().filter(word -> word.startsWith("" + symbol)).count();
    }

    public static List<String> getWordsContainingSubstring(@NotNull List<String> words, String substring) {
        return words.stream().filter(word -> word.contains(substring)).toList();
    }

    public static List<String> sortByWordsLength(@NotNull List<String> words) {
        return words.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<Integer> getWordsLength(@NotNull List<String> words) {
        return words.stream().map(String::length).toList();
    }
}
