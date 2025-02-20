package school.faang.bjs2_58118;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(n -> n != sum - n && numbers.contains(sum - n))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCountriesAndGetCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

    }

    public static List<String> sortedStringsByLengthStartWith(List<String> words, char character) {
        return words.stream()
                .filter(s -> s.startsWith(character + ""))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertNumbersToBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterStringsAlphabeticallyAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

}
