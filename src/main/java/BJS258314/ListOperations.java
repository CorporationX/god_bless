package BJS258314;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {

    public Integer sumEvenNumbers(List<Integer> numbersList) {
        Integer sum = 0;
        Stream<Integer> evenNumbers = numbersList.stream().filter(num -> num % 2 == 0);
        sum = evenNumbers.reduce(sum, Integer::sum);
        return sum;
    }

    public Integer getMaxNumber(List<Integer> numbersList) {
        return numbersList.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No number found"));
    }

    public Double getAverage(List<Integer> numbersList) {
        return numbersList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

    }

    public long getNumberStringWithSymbol(List<String> stringList, char symbol) {
        return stringList.stream()
                .filter(string ->
                        !string.isEmpty() && string.charAt(0) == symbol)
                .count();
    }

    public List<String> stringListWithSubstring(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(s ->
                        !s.isEmpty() && s.contains(substring))
                .collect(Collectors.toList());
    }

    public List<String> sortedByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public boolean elementsFilter(List<Integer> numbersList, Predicate<Integer> predicate) {
        return numbersList.stream()
                .allMatch(predicate);
    }

    public Integer findMinElementThenGreaterNumber(List<Integer> numbersList, int number) {
        return numbersList.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Ellement not found"));
    }

    public List<Integer> stringLength(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
