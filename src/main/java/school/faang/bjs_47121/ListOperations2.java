package school.faang.bjs_47121;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOperations2 {
    public static Map<Integer, Integer> getPairOfNumbers(List<Integer> numbers, int sum) {
        Map<Integer, Integer> pairNumbers = new HashMap<>();

        numbers.forEach(number -> {
            int secondNumber = sum - number;

            if (numbers.contains(secondNumber) && !pairNumbers.containsKey(secondNumber)
                    && !pairNumbers.containsValue(secondNumber)) {
                pairNumbers.put(number, secondNumber);
            }

        });
        return pairNumbers;
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getFilteredAndSortedStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> getNumbersInBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

}
