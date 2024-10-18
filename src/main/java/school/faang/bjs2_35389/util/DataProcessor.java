package school.faang.bjs2_35389.util;


import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DataProcessor {
    public List<PairInteger> findUniquePairsSumOfWhichEqualTo(@NonNull List<Integer> numbers, int sum) {
        return numbers.stream()
                .flatMap(integer -> numbers.stream()
                        .filter(integer2 -> integer + integer2 == sum)
                        .filter(integer3 -> integer <= integer3)
                        .map(integer4 -> new PairInteger(integer, integer4)))
                .distinct()
                .toList();
    }

    public List<String> sortCountriesAndGetCapitals(@NonNull Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterAndSortStrings(@NonNull List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startChar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> convertNumbersToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAndSortByAlphabetAndLength(@NonNull List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.matches("^[ " + alphabet + "]+$"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
