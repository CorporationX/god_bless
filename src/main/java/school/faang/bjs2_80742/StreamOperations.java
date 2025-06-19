package school.faang.bjs2_80742;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public static Set<List<Integer>> findUniquePairsEqualToNumber(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());


    }

    public static List<String> printCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted((s1, s2) -> s1.getKey().compareToIgnoreCase(s2.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortStringsStartingWithChar(List<String> strings, char startingChar) {
        return strings.stream()
                .filter(s -> s.charAt(0) == startingChar)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertDecimalToBinary(List<Integer> decimals) {
        return decimals.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        List<Character> alphabetList = new ArrayList<>();
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetList.add(alphabet.toCharArray()[i]);
        }

        return strings.stream()
                .filter(s -> {
                    List<Character> buffer = new ArrayList<>();
                    for (int i = 0; i < s.length(); i++) {
                        buffer.add(s.toCharArray()[i]);
                    }
                    return alphabetList.containsAll(buffer);
                })
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
    }
}
