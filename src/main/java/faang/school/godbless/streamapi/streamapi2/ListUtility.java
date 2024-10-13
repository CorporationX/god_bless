package faang.school.godbless.streamapi.streamapi2;

import lombok.NonNull;

import java.util.*;

public class ListUtility {
    private ListUtility() {
    }

    public static List<List<Integer>> findPairsWithSpecificSum(@NonNull List<Integer> numbers, int sum) {
        if (numbers.size() <= 1) {
            return new ArrayList<>();
        }
        var pairs = new ArrayList<List<Integer>>();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == sum) {
                    pairs.add(Arrays.asList(numbers.get(i), numbers.get(j)));
                }

            }
        }
        return pairs;
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
