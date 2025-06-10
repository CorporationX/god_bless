package school.faang.bjs2_80634_stream_2;

import lombok.NonNull;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<IntPair> uniqueSumPairs(@NonNull Set<Integer> numbers, int targetSum) {
        Set<IntPair> pairs = new HashSet<>();
        Set<Integer> extraNumbers = new HashSet<>(numbers);

        numbers.forEach(number -> {
            List<Integer> matches = extraNumbers.stream()
                    .filter(newNumber -> number + newNumber == targetSum)
                    .toList();
            matches.forEach(matchedNumber -> {
                if (!matchedNumber.equals(number)) {
                    pairs.add(new IntPair(number, matchedNumber));
                }
            });
        });

        return pairs;
    }

    public static List<String> capitalsSortedByCountry(@NonNull Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> stringsSortedByLengthAndFilteredByStartingChar(
            @NonNull List<String> strings,
            char target) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(target)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortAndFilterByAlphabet(@NonNull List<String> strings, @NonNull String alphabet) {
        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(HashSet::new));

        return strings.stream()
                .filter(s -> s.chars()
                        .mapToObj(c -> (char) c)
                        .allMatch(alphabetSet::contains)
                )
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

