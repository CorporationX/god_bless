package school.faang.bjs2_87982_stream_API2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Methods {
    public static List<List<Integer>> findUniqueNumbersPairWithSum(Set<Integer> numbers, int targetSum) {
        if (numbers == null) {
            throw new IllegalArgumentException("Набор чисел не может быть null");
        }

        Set<Integer> seen = new HashSet<>();

        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(num -> {
                    int complement = targetSum - num;
                    if (seen.contains(complement)) {
                        return true;
                    }
                    seen.add(num);
                    return false;
                })
                .map(num -> {
                    int complement = targetSum - num;
                    return List.of(Math.min(num, complement), Math.max(num, complement));
                })
                .distinct()
                .toList();
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> mapCountriesAndCapitals) {
        if (mapCountriesAndCapitals == null) {
            throw new IllegalArgumentException("Карта столиц не может быть null");
        }
        return mapCountriesAndCapitals.entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .filter(Objects::nonNull)
                .toList();
    }

    public static List<String> filterStringsByStartingCharAndSortByLength(List<String> list, char ch) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }
        return list.stream()
               .filter(Objects::nonNull)
               .filter(s -> s.startsWith(String.valueOf(ch)))
               .sorted(Comparator.comparingInt(String::length))
               .toList();
    }

    public static Optional<List<String>> toBinaryStringList(List<Integer> integerList) {
        if (integerList == null) {
            return Optional.empty();
        }
        List<String> list = integerList.stream()
                .filter(Objects::nonNull)
                .map(Integer::toBinaryString)
                .toList();
        return Optional.of(list);
    }

    public static List<String> filterByAlphabetAndLength(List<String> words, String alphabet) {
        if (alphabet == null || alphabet.isEmpty()) {
            throw new IllegalArgumentException("Алфавит не может быть null");
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