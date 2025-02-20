package school.faang.naughtwoBJS258161;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionOperations {

    public static Map<Integer, Integer> findPairsOfNumbers(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num < sum && num != sum - num && numbers.contains(sum - num))
                .collect(Collectors.toMap(num -> num, num -> (sum - num)));
    }

    public static Set<String> convertingToBinary(Set<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toSet());
    }


    public static List<String> sortCountriesAndReturnCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.charAt(0) == ch)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
