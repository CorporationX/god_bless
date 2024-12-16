package school.faang.bjs24722;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findUniquePairsOfNumbers(List<Integer> numbers, int sum) {
        return numbers.stream()
                .distinct()
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAndEnterCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> mapToBinaryAsStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAbcAndSortAscStrings(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        Pattern pattern = Pattern.compile(regex);
        return strings.stream()
                .filter(s -> pattern.matcher(s).matches())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}