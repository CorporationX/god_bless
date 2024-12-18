package derschrank.sprint02.task09.bjstwo_47648;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class StreamApi2 implements StreamApi2Interface {
    public List<List<Integer>> findSum(List<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(x -> numbers.contains(sum - x)
                        && (x != (sum - x) || Collections.frequency(numbers, x) > 1))
                .map(x -> List.of(Math.min(x, sum - x), Math.max(x, sum - x)))
                .distinct()
                .sorted(Comparator.comparingInt(o -> o.get(0)))
                .toList();
    }


    public List<String> sortCountryAndGetCapital(Map<String, String> countryAndCapital) {
        return countryAndCapital
                .keySet()
                .stream()
                .sorted()
                .map(countryAndCapital::get)
                .toList();
    }

    public List<String> findCharAndSortStrings(List<String> strings, char ch) {
        return strings.stream()
                .filter(x -> x.startsWith(Character.toString(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> makeDecToBin(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterStringsByAlphabetAndSortByLength(List<String> string, String alphabet) {
        Predicate<String> isAllCharsFromAlphabet = word -> word.chars()
                .allMatch(ch -> alphabet.contains(Character.toString(ch)));

        return string.stream()
                .filter(isAllCharsFromAlphabet)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}