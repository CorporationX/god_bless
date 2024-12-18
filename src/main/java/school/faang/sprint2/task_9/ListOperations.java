package school.faang.sprint2.task_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ListOperations {

    public static List<List<Integer>> sumLists(List<Integer> numbers, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        IntStream.range(0, numbers.size())
                .forEach(i -> IntStream.range(i + 1, numbers.size())
                        .filter(j -> numbers.get(i) + numbers.get(j) == target)
                        .forEach(j -> pairs.add(Arrays.asList(Math.min(numbers.get(i),
                                numbers.get(j)), Math.max(numbers.get(i), numbers.get(j))))));

        return pairs;
    }

    public static List<String> sortCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> filterFruits(List<String> fruits, String symbol) {
        return fruits.stream().filter(fruit -> fruit.startsWith(symbol))
                .sorted(Comparator.comparingInt(String::length))
                .sorted(Comparator.comparing(String::toLowerCase))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> sortWords(List<String> wordsToSort, String alphabet) {
        return wordsToSort.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf((char) c) != -1))
                .sorted(Comparator.comparing(String::toLowerCase))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
