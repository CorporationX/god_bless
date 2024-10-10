package school.faang.stream.api.two;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiTwoService {

    public static List<List<Integer>> findUniquePairsOfNumbers(List<Integer> numbers, Integer target) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return numbers.stream()
                .sorted()
                .filter(number -> uniqueNumbers.contains(target - number))
                .map(number ->
                        Arrays.asList(
                                Math.min(number, target - number),
                                Math.max(number, target - number)
                        )
                )
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortAndFilterRowsByChar(List<String> rows, char ch) {
        return rows.stream()
                .filter(row -> row.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(String::compareTo))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> sortAndFilterRowsByAlphabet(List<String> rows, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return rows.stream()
                .filter(row -> row.matches(regex))
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(String::compareTo))
                .collect(Collectors.toList());
    }
}
