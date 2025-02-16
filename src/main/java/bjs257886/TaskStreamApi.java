package bjs257886;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskStreamApi {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static Set<List<Integer>> findUniquePairsNumbers(Set<Integer> numbersParameter, int targetNumber) {
        return numbersParameter.stream()
                .filter(firstNum -> {
                    int secondNum = targetNumber - firstNum;
                    return firstNum < secondNum && numbersParameter.contains(secondNum);
                })
                .map(firstNum -> List.of(firstNum, targetNumber - firstNum))
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> findAndSortStrings(List<String> strings, char startSymbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(startSymbol)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinaryFormat(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterStringsAndSortByLength(List<String> strings, String alphabet) {
        alphabet = ALPHABET;
        String finalAlphabet = alphabet;
        return strings.stream()
                .filter(string -> !string.isBlank() && string.matches("[" + finalAlphabet + "]*"))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
