package school.faang.sprint_2.streamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Processor {
    public static Set<List<Integer>> findPairsEqualTarget(Set<Integer> numbers, Integer target) {
        return numbers
                .stream()
                .filter(number -> numbers.contains(target - number))
                .filter(number -> number != target - number)
                .map(number -> Arrays.asList(number, target - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountryByAlphabetAndReturnCapitals(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals.keySet().stream().sorted(Comparator.naturalOrder())
                .map(country -> countriesWithCapitals.get(country))
                .toList();
    }

    public static List<String> convertingNumbersToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }
}
