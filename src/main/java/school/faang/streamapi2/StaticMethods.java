package school.faang.streamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StaticMethods {
    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int value) {
        return numbers.stream()
                .filter(number -> value != number * 2 && numbers.contains(value - number))
                .map(number -> Arrays.asList(number, value - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortList(List<String> words, char startingChar) {
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(startingChar)))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> Integer.toBinaryString(number))
                .toList();
    }

    public static List<String> filterByAlphabet(List<String> words, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return words.stream()
                .filter(word -> word.matches(regex))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }
}