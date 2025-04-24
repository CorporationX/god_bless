package school.faang.bjs2_70936;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class ListOperations {

    public static List<int[]> sumOfNumber(List<Integer> numbers, int goal) {
        Set<Integer> seen = new HashSet<>(numbers.size());
        // Почему это работает с flatMap но не с map их разница ведь в том,
        // что flatMap превращает List<List<?>> в List<?>, map же просто проходит по данному списку.
        return numbers.stream()
                .flatMap(number -> {
                    int diff = goal - number;
                    if (seen.contains(diff)) {
                        return Stream.of(new int[]{number, diff});
                    }
                    seen.add(diff);
                    return Stream.empty();
                }).toList();
    }

    public static List<String> sortCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> sortedByLengthWithLetter(List<String> words, char letter) {
        return words.stream()
                .filter(word -> word.charAt(0) == letter)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortAlphabeticallyThenByLength(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> word.chars()
                        .allMatch(character -> alphabet.indexOf(character) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
