package org.example.service.trainingStream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void findPairNumbers(List<Integer> numbers, int targetNumber) {
        Set<Integer> seenNumbers = new HashSet<>();
        numbers.stream()
                .distinct()
                .filter(num -> {
                    boolean hasPair = seenNumbers.contains(targetNumber - num);
                    seenNumbers.add(num);
                    return hasPair;
                })
                .forEach(num -> System.out.print("(" + num + ", " + (targetNumber - num) + "), "));
    }

    public static List<String> getSortedCapitals(Map<String, String> capitalsByCountry) {
        return capitalsByCountry.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> getWordsContainsSymbol(List<String> words, char symbol) {
        return words.stream()
                .filter(word -> word.startsWith(Character.toString(symbol)))
                .sorted()
                .toList();
    }

    public static List<String> decimalToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortingWordsWhichContainsString(List<String> words, String letters){
        return words.stream()
                .filter(word -> Arrays.stream(letters.split("")).anyMatch(word::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
