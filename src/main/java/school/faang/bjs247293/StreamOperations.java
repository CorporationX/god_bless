package school.faang.bjs247293;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public static Set<List<Integer>> uniquePairNumbers(List<Integer> numbers, int sumPairNumbers) {
        Set<List<Integer>> uniquePairs = new HashSet<>();
        Set<Integer> number = new HashSet<>();
        number.addAll(numbers);
        uniquePairs = numbers.stream()
                .filter(num -> number.contains(sumPairNumbers - num))
                .map(num -> Arrays.asList(num, sumPairNumbers - num))
                .peek(list -> Collections.sort(list))
                .collect(Collectors.toSet());
        return uniquePairs;
    }

    public static List<String> sortingCountry(Map<String, String> cityCountry) {
        return cityCountry.values()
                .stream()
                .sorted()
                .toList();
    }

    public static List<String> filterBySymbolAndSorting(List<String> strings, char symbol) {
        return strings.stream()
                .filter(word -> Objects.equals(Character.toLowerCase(word.charAt(0)), Character.toLowerCase(symbol)))
                .sorted(((o1, o2) -> o1.length() - o2.length()))
                .toList();
    }

    public static List<String> mappingNumInWordDivided(List<Integer> numbers) {
        return numbers.stream()
                .map(integer -> Integer.toBinaryString(integer))
                .toList();
    }

    public static List<String> filterWordByAlphabet(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> word.matches("[" + alphabet + "]+"))
                .sorted((o1, o2) -> o1.length() - o2.length())
                .toList();
    }
}
