package school.faang.lets_practice_streamAPI_2.BJS2_58055;

import lombok.NonNull;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<NumberPair> findPairsWithSum(@NonNull Set<Integer> numbers, int sum) {
        Set<NumberPair> numberPairs = new HashSet<>();
        numbers.forEach(num -> {
            numbers.stream()
                    .filter(integer -> integer + num == sum)
                    .filter(integer -> !integer.equals(num))
                    .findFirst()
                    .ifPresent(pair -> {
                        numberPairs.add(new NumberPair(pair, num));
                    });
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
        return numbers.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<String> filteringStringsAlphabeticallyAndSortingByLength(
            @NonNull List<String> words, @NonNull String alphabet) {

        Set<String> letters = stringToSetConversion(alphabet);

        return words.stream()
                .filter(word -> {
                    Set<String> wordLetters = stringToSetConversion(word);
                    return letters.containsAll(wordLetters);
                })
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static Set<String> stringToSetConversion(String string) {
        return string
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toSet());
    }
}
