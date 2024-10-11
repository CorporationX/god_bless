package school.faang.godbless.bjs2_35185;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;

public class StreamOperationsManager {
    public static List<Pair<Integer>> getPairsThatSumUpToTarget(@NonNull List<Integer> numbers, int target) {
        Set<Integer> numsSet = new HashSet<>();
        Set<Pair<Integer>> res = new HashSet<>();

        numbers.forEach(num -> {
            if (numsSet.contains(target - num)) {
                res.add(new Pair<>(num, target - num).sort(Integer::compareTo));
            }
            numsSet.add(num);
        });

        return res.stream().toList();
    }

    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    public static class Pair<T> {
        private T firstObject;
        private T secondObject;

        @Override
        public String toString() {
            return firstObject + " : " + secondObject;
        }

        public Pair<T> sort(Comparator<T> comparator) {
            if (comparator.compare(firstObject, secondObject) > 0) {
                T tmp = firstObject;
                firstObject = secondObject;
                secondObject = tmp;
            }
            return this;
        }
    }

    public static List<String> getCapitalsOfSortedCountries(@NonNull Map<String, String> countries) {
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> getFilteredByStartWithSymbolAndSortedByLength(@NonNull List<String> words, char symbol) {
        return words.stream().filter(word -> !word.isEmpty() && word.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> getNumbersAsBinary(@NonNull List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> getFilteredByAlphabetAndSortedByLength(@NonNull List<String> words, @NonNull String alphabet) {
        Set<Character> alphabetSet = new HashSet<>();
        alphabet.chars().forEach(symbol -> alphabetSet.add((char) symbol));
        return words.stream().filter(word ->
                word.chars().allMatch(symbol -> alphabetSet.contains((char) symbol))
        ).sorted(Comparator.comparingInt(String::length)).toList();
    }
}
