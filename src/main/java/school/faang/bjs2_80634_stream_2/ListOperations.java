package school.faang.bjs2_80634_stream_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<IntPair> uniqueSumPairs(Set<Integer> numbers, int targetSum) {
        Set<IntPair> pairs = new HashSet<>();
        if (numbers == null) {
            return pairs;
        }
        Set<Integer> extraNumbers = new HashSet<>(numbers);

        numbers.forEach(number -> {
            List<Integer> matches = extraNumbers.stream().filter(
                    newNumber -> number + newNumber == targetSum
            ).toList();
            matches.forEach(matchedNumber -> {
                if (!matchedNumber.equals(number)) {
                    pairs.add(new IntPair(number, matchedNumber));
                }
            });
        });

        return pairs;
    }

    public static List<String> capitalsSortedByCountry(Map<String, String> countries) {
        if (countries == null) {
            return new ArrayList<>();
        }
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> stringsSortedByLengthAndFilteredByStartingChar(List<String> strings, char target) {
        if (strings == null) {
            return new ArrayList<>();
        }

        return strings.stream().filter(
                string -> string.startsWith(String.valueOf(target))
        ).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        if (numbers == null) {
            return new ArrayList<>();
        }

        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> sortAndFilterByAlphabet(List<String> strings, String alphabet) {
        if (strings == null || alphabet == null) {
            return new ArrayList<>();
        }

        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(HashSet::new));

        return strings.stream().filter(s ->
            s.chars().mapToObj(c -> (char) c).allMatch(alphabetSet::contains)
        ).sorted(Comparator.comparingInt(String::length)).toList();

    }
}

