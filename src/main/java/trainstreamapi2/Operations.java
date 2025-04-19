package trainstreamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Operations {

    public static List<List<Integer>> findUniquePairs(Set<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a < b && a + b == target)
                        .map(b -> List.of(a, b))
                ).toList();
    }

    public static List<String> sortCountriesAndPrintCapitals(Map<String, String> countriesToCapitals) {
        return countriesToCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
