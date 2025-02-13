package school.faang.task58236.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public int summaChet(List<Integer> numb) {
        int result = 0;
        result = numb.stream()
                .filter((num) -> num % 2 == 0)
                .reduce(0, Integer::sum);
        return result;
    }

    public int maxElement(List<Integer> numb) {
        int result = 0;
        result = numb.stream()
                .max(Integer::compareTo).orElse(0);
        return result;
    }

    public double midElement(List<Integer> numb) {
        return numb.stream()
                .mapToDouble(value -> (double) value)
                .average()
                .orElse(0.0);
    }

    public long findStartChar(List<String> strings, char startSymbol) {
        return strings.stream()
                .filter(startCh -> startCh.charAt(0) == startSymbol)
                .count();
    }

    public List<String> findSubString(List<String> strings, String subString) {
        List<String> result = strings.stream()
                .map(String::toLowerCase)
                .filter(subStr -> subStr.contains(subString))
                .toList();
        return result;
    }

    public List<String> sortToLength(List<String> strings) {
        return strings.stream()
                .sorted((Comparator.comparingInt(String::length)))
                .toList();
    }

    public boolean checkIf(List<Integer> numbers, Predicate<Integer> checkIf) {
        return numbers.stream()
                .allMatch(checkIf);
    }

    public int findMinAfterValue(List<Integer> numbs, int after) {
        return numbs.stream()
                .filter(integer -> integer > after)
                .min(Integer::compare)
                .orElse(0);

    }

    public List<Integer> mapStrToInt(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}