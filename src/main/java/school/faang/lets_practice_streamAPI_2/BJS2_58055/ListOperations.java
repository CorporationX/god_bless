package school.faang.lets_practice_streamAPI_2.BJS2_58055;

import lombok.NonNull;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListOperations {

    public static Set<NumberPair> findPairsWithSum(@NonNull Set<Integer> numbers, int sum) {
        Set<NumberPair> numberPairs = new HashSet<>();
        Set<Integer> seenNumbers = new HashSet<>();

        numbers.forEach(num -> {
            int complement = sum - num;
            if (seenNumbers.contains(complement)) {
                numberPairs.add(new NumberPair(complement, num));
            }
            seenNumbers.add(num);
        });

        return numberPairs;
    }

    public static List<String> sortingCapitals(@NonNull Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream().map(Map.Entry::getValue).sorted().toList();
    }

    public static List<String> filteringAndSortingOfStrings(@NonNull List<String> list, char value) {
        return list.stream()
                .filter(string -> string.startsWith(String.valueOf(value)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertingNumbersToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filteringStringsAlphabeticallyAndSortingByLength(
            @NonNull List<String> words, @NonNull String alphabet) {

        return words.stream()
                .filter(word -> word.chars()
                        .allMatch(ch -> alphabet.indexOf(ch) >= 0))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
