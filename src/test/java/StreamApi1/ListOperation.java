package StreamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListOperation {
    public int sum(List<Integer> numbers) {
        return numbers.stream()
                .filter(a -> a % 2 == 0)
                .reduce(0, (a, b) -> a + b); // .reduce(0, Integer::sum);
    }

    public int max(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream()
                .reduce((x, y) -> x > y ? x : y);
        Integer maxValue = max.orElse(0);
        return maxValue;
    }

    public int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public double findArifmeticMean(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public int countStringWithChar(List<String> stringList, char ch) {
        return (int) stringList.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public List<String> countStringWitFragment(List<String> stringList, String str) {
        return stringList.stream()
                .filter(s -> s.contains(str))
                .toList();
    }

    public List<String> sortByLenth(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparing(String::length))//.sorted((s1,s2)->Integer.compare(s1.length(), s2.length()))
                .toList();
    }

    public boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public int minForSublist(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(n -> n > num)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No elements greater than: " + num));
    }

    public List<Integer> lenthString(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
