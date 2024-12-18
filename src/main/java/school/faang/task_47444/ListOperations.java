package school.faang.task_47444;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ListOperations {
    public static Set<List<Integer>> foundPairsOfSum(List<Integer> integerList, int sum2Number) {
        Set<Integer> integerSet = new HashSet<>(integerList);

        return integerList.stream()
                .filter(n -> integerSet.contains(sum2Number - n))
                .map(n -> Arrays.asList(n, sum2Number - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static Set<String> sortedCaps(Map<String, String> countriesCap) {
        return countriesCap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCharAndLenght(List<String> wordList, String symbol) {
        return wordList.stream()
                .filter(word -> word.substring(0, 1).equals(symbol))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> numberToBinaryNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n.toBinaryString(n))
                .collect(Collectors.toList());
    }

    public static List<String> checkWordInAlphabet(List<String> words, String alphabet) {
        return words.stream()
                .filter(str -> str.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
