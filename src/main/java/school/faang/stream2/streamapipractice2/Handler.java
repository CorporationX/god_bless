package school.faang.stream2.streamapipractice2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Handler {

    public List<List<Integer>> findUniquePairs(Set<Integer> numbers, int targetSum) {
        return numbers.stream()
                .flatMap(num -> numbers.stream()
                        .filter(otherNum -> num < otherNum && num + otherNum == targetSum)
                        .map(otherNum -> Arrays.asList(num, otherNum)))
                .toList();
    }

    public List<String> showCapitalsOfCountriesSortedByAlfabet(Map<String, String> capitals) {
        return capitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> findStringsStartingWith(List<String> strings, Character beginning) {
        return strings.stream()
                .filter(string -> string.charAt(0) == beginning)
                .toList();
    }

    public List<String> getNumbersInBinarySystem(List<Integer> numbersInDecimalSystem) {
        return numbersInDecimalSystem.stream()
                .map(integer -> Integer.toBinaryString(integer))
                .toList();
    }

    public List<String> checkLettersAndSortWordsByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.chars()
                        .allMatch(ch -> alphabet.indexOf(ch) >= 0)
                )
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .toList();
    }
}
