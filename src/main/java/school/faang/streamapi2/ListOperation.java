package school.faang.streamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOperation {
    public static Map<Integer, Integer> findPairsOfNumbers(List<Integer> numbers, Integer target) {
        return IntStream.range(0, numbers.size()).boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .filter(j -> numbers.get(i) + numbers.get(j) == target)
                        .mapToObj(j -> Map.entry(numbers.get(i), numbers.get(j))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Set<String> sortByCountry(Map<String, String> countryCapitals) {
        return countryCapitals.values().stream().collect(Collectors.toSet());
    }

    public static List<String> filterAndSort(List<String> strings, char startChar) {
        return strings.stream().filter(s -> s.startsWith(String.valueOf(startChar)))
                .sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static List<String> filterAndSort(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

}