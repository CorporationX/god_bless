package faang.school.godbless.streamapi.streamapi2;

import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListUtility {
    private ListUtility() {
    }

    public static Set<List<Integer>> findPairsWithSpecificSum(@NonNull List<Integer> numbers, int sum) {
        var uniqueNumbers = new HashSet<>(numbers);
        return numbers.stream()
                .filter(n -> uniqueNumbers.contains(sum - n))
                .map(n -> Stream.of(n, sum - n).sorted().toList())
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> findAndSortStringStartWithSymbol(@NonNull List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> s != null && s.length() > 0 && s.charAt(0) == symbol)
                .sorted((Comparator.comparingInt(String::length)))
                .toList();
    }

    public static List<String> toBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> getSortedStringsByLengthFromAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) != -1))
                .sorted((Comparator.comparingInt(String::length)))
                .toList();
    }

}
