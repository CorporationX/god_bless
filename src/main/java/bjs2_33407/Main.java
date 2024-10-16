package bjs2_33407;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Integer> inputNums = List.of(1, 2, 3, 4, 5, 6);
        List<String> inputStrs = List.of("apple", "banana", "avocado", "apricot", "smth");
        Map<String, String> countryToCapital = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        System.out.println(StreamOperations.findUniquePairsEqualTarget(inputNums, 12));
        System.out.println(StreamOperations.getSortedCountryCapitals(countryToCapital));
        System.out.println(StreamOperations.filterAndSort(inputStrs, 'a'));
        System.out.println(StreamOperations.toBinary(inputNums));
        System.out.println(StreamOperations.containsCharFromAlphabet(inputStrs, "abcdefg"));
    }
}
