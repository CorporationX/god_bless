package school.faang.task_47488;

import java.util.*;

public class ListOperations {

    public static List<Set<Integer>> uniqueCoupleNumbers(List<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(number -> numbers.stream()
                        .filter(n -> n + number == target)
                        .map(n -> Set.of(number, n)))
                .distinct()
                .toList();
    }

    public static List<String> countrySort(Map<String, String> countries) {
        return countries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSorting(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(Character.toString(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSorting(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> Arrays.stream(alphabet.split(""))
                        .anyMatch(string::startsWith))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

}
