package school.faang.filter_by_alphabet_sort_by_length;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> sortedWords = sortWordsWithAlphabetSymbols(words, alphabet);
        System.out.println(sortedWords);
    }

    private static List<String> sortWordsWithAlphabetSymbols(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> !alphabetContainsSymbol(alphabet, word))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    private static boolean alphabetContainsSymbol(String alphabet, String word) {
        for (char symbol : word.toCharArray()) {
            if (alphabet.indexOf(symbol) == -1) {
                return true;
            }
        }

        return false;
    }
}
