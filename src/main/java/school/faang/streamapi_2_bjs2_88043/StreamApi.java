package school.faang.streamapi_2_bjs2_88043;

import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@ToString
public class StreamApi {
    public static Set<List<Integer>> findPairsNumbers(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(number -> number < sum - number && numbers.contains(sum - number))
                .map(number -> Arrays.asList(number, sum - number))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> country) {
        return country.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> number) {
        return number.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> liststrings, String alphabet) {
        return liststrings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.contains(String.valueOf((char) c))))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
