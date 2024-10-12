package school.faang.sream_api2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int desiredResult = 7;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 4, 3, 6, 7, 2);
        List<List<Integer>> resultMap = findPairNumberFromDesire(numbers,desiredResult);
        System.out.println(resultMap);

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("England", "London");
        countries.put("France", "Paris");
        List<String> cities = getCityFromCountry(countries);
        System.out.println(cities);

        List<String> words = List.of("Ananas", "Adam", "Eva", "Maks", "Aleks", "Abakan", "Resolve");
        System.out.println(sortingWordsFromSymbol(words, "A"));

        List<Integer> numbersList = List.of(1, 5, 6, 2);
        System.out.println(getBinaryNumbers(numbersList));

        List<String> allWords = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        System.out.println(validationWords(allWords));

    }

    private static List<List<Integer>> findPairNumberFromDesire(List<Integer> numbers, int desireResult) {
        return numbers.stream()
                .flatMap(numberFirst -> numbers.stream()
                        .filter(numberSecond -> numberFirst + numberSecond == desireResult)
                        .map(numberSecond -> List.of(numberFirst, numberSecond).stream().sorted().toList()))
                .toList().stream().distinct().toList();
    }

    private static List<String> getCityFromCountry(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> sortingWordsFromSymbol(List<String> words, String symbol) {
        return words.stream()
                .filter(word -> word.startsWith(symbol))
                .sorted()
                .toList();
    }

    private static List<String> getBinaryNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    private static List<String> validationWords(List<String> words) {
        return words.stream()
                .filter(isValid)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static Predicate<String> isValid = word -> {
        Boolean result = false;
        List<String> arraySymbols = List.of("acdefghijklmnopqrstuvwxyz".split(""));
        String[] arraySymbolsWord = word.split("");
        for (String symbol : arraySymbolsWord) {
            if (arraySymbols.contains(symbol)) {
                result = true;
            } else {
                return false;
            }
        }
        return result;
    };
}


