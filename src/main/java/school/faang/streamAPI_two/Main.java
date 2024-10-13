package school.faang.streamAPI_two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<String, String> countries = new HashMap<>(Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        ));
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "avocado", "apricot");

        System.out.println("Unique pairs equals to sum 10 are: "
                + ListOperations.findUniquePairsWithSum(numbers, 10));
        System.out.println("Countries sorted in alphabet order, their capitals printed out: "
                + ListOperations.getSortedCapitals(countries));
        System.out.println("Strings starts with 'a' and sorted by length: "
                + ListOperations.filterAndSort(strings, 'a'));
        System.out.println("Numbers converted to binary: "
                + ListOperations.convertToBinary(numbers));
        System.out.println("Strings that only have symbols from the alphabet(no letter 'c' here) and sorted by length: "
                + ListOperations.filterAndSort(strings, "abdefghijklmnopqrstuvwxyz"));
    }
}