package school.faang.bjs2_88133;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi {
    public static Set<Set<Integer>> findUniquePairsWithSum(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(a -> numbers.contains(target - a))
                .filter(a -> a < target - a)
                .map(a -> Set.of(a, target - a))
                .collect(Collectors.toSet());
    }

    public static List<String> capitalsByCountrySorted(Map<String, String> countryCapital) {
        if (countryCapital == null) {
            throw new IllegalArgumentException("Карта countryCapital не должна быть null");
        }
        Set<Map.Entry<String, String>> entries = countryCapital.entrySet();
        return entries.stream()
                .filter(e -> e.getKey() != null && e.getValue() != null)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterStartingWithAndSortByLength(List<String> list, Character ch) {
        if (ch == null) {
            throw new IllegalArgumentException("Start character must not be null");
        }
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        return list.stream()
                .filter(e -> e != null)
                .map(String::trim)
                .filter(e -> !e.isBlank())
                .filter(e -> Character.toLowerCase(e.charAt(0)) == Character.toLowerCase(ch))
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase))
                .collect(Collectors.toList());
    }

    public static List<String> toBinaryStrings(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Не может быть null");
        }
        return list.stream()
                .filter(Objects::nonNull)
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> list, String letters) {
        if (list == null) {
            throw new IllegalArgumentException("Не может быть null");
        }
        if (letters == null) {
            throw new IllegalArgumentException("Не может быть null");
        }
        String lettersNormalized = letters.strip();
        if (lettersNormalized.isBlank()) {
            throw new IllegalArgumentException("Алфавит не должен быть пустым/состоять из пробелов");
        }
        Set<Character> allowed = lettersNormalized.toLowerCase(Locale.ROOT)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return list.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .filter(s -> s.toLowerCase(Locale.ROOT)
                .chars()
                .allMatch(c -> allowed.contains((char) c)))
                .sorted(Comparator
                        .comparingInt(String::length)
                        .thenComparing(String::compareToIgnoreCase))
                .collect(Collectors.toList());
    }
}
