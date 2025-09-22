package school.faang.bjs2_87982_stream_API2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Methods {
    public static List<List<Integer>> findUniqueNumbersPairWithSum(Set<Integer> numbers, int targetSum) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .flatMap(n1 -> numbers.stream()
                        .filter(n2 -> n1 < n2)
                        .filter(n2 -> n1 + n2 == targetSum)
                        .map(n2 -> List.of(n1, n2)))
                .toList();
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> mapCountriesAndCapitals) {
        if (mapCountriesAndCapitals == null) {
            return new ArrayList<>();
        }
        return mapCountriesAndCapitals.entrySet().stream()
                    .filter(entry -> entry.getKey() != null)
                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getValue)
                    .filter(Objects::nonNull)
                    .toList();
    }

    public static List<String> filterStringsByStartingCharAndSortByLength(List<String> list, char ch) {
        return list.stream()
               .filter(Objects::nonNull)
               .filter(s -> s.startsWith(String.valueOf(ch)))
               .sorted(Comparator.comparingInt(String::length))
               .toList();
    }

    public static Optional<List<String>> toBinaryStringList(List<Integer> integerList) {
        return integerList.stream()
                .filter(Objects::nonNull)
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndLength(List<String> words, String alphabet) {
        if (alphabet == null || alphabet.isEmpty()) {
            throw new IllegalArgumentException("Алфавит не может быть пустым");
        }
        if (words == null) {
            return List.of();
        }
        return words.stream()
                .filter(Objects::nonNull)
                .filter(w -> w.matches("^[" + alphabet + "]+$"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}