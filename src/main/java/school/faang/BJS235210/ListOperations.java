package school.faang.BJS235210;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> getUniquePair(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitalsSorted(Map<String, String> countryCapitals) {
        return countryCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> getSortedFruitsByLetter(List<String> fruits, String letter) {
        return fruits.stream()
                .filter(fruit -> fruit.startsWith(letter))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> getBinaryDigit(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> {
                    int boost = number;
                    String binaries = "";
                    while (boost != 0) {
                        if (boost % 2 == 1) {
                            binaries += "1";
                        } else {
                            binaries += "0";
                        }
                        boost /= 2;
                    }
                    return binaries;
                }).collect(Collectors.toList());
    }

    public static List<String> getFilteredAndSortedByLength(List<String> words, String alphabet) {
        String regex = "[" + alphabet + "](.*?)+[" + alphabet + "]";
        return words.stream()
                .filter(w -> w.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
