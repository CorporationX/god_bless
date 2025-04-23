package school.faang.bjs2_70936;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOperations {

    public static List<int[]> sumOfNumber(List<Integer> numbers, int goal) {
        return IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .filter(j -> numbers.get(i) + numbers.get(j) == goal)
                        .mapToObj(j -> new int[]{numbers.get(i), numbers.get(j)})
                ).collect(Collectors.toList());
    }

    public static List<String> sortCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> sortedByLengthWithLetter(List<String> words, char letter) {
        return !words.isEmpty()
                ? words.stream()
                .filter(word -> word.charAt(0) == letter)
                .sorted((w1, w2) -> w1.length() >= w2.length() ? 1 : -1)
                .toList()
                : new ArrayList<>();
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
