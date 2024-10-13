package school.faang.streamtraining2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamUtils {
    // этот метод сам осилить не смог, посмотрел подсказку, но в итоге разобрался, как это работает
    public static Set<List<Integer>> uniquePairs(List<Integer> list, int targetNum) {
        Set<Integer> uniqueElements = new HashSet<>(list);

        return list.stream()
                .filter(num -> uniqueElements.contains(targetNum - num))
                .map(num -> Arrays.asList(num, targetNum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> returnCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Entry.comparingByKey())
                .map(Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortList(List<String> list, char firstSymbol) {
        return list.stream()
                .filter(str -> str.charAt(0) == firstSymbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> decimalToBinary(List<Integer> list) {
        return list.stream().map(num -> Integer.toString(num, 2)).toList();
    }

    public static List<String> filterSortToAlphabet(List<String> list, String alphabet) {
        return list.stream()
                .filter(word -> checkWord(word, alphabet))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // может это можно было сделать как-то проще? Я не додумался
    private static boolean checkWord(String word, String alphabet) {
        return word
                .chars()
                .mapToObj(item -> String.valueOf((char) item))
                .allMatch(alphabet::contains);
    }
}
