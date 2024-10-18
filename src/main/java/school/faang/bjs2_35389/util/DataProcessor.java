package school.faang.bjs2_35389.util;


import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class DataProcessor {
    public List<PairInteger> findUniquePairsSumOfWhichEqualTo(@NonNull List<Integer> numbers, int sum) {
        AtomicLong count = new AtomicLong(0);
        return numbers.stream()
                .flatMap(firstNumberPair -> numbers.stream()
                        .skip(count.incrementAndGet())
                        .filter(secondNumberPair -> firstNumberPair + secondNumberPair == sum)
                        .map(secondNumberPair -> new PairInteger(firstNumberPair, secondNumberPair)))
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
