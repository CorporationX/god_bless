package school.faang.bjs2_80634_stream_2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Set<IntPair> pairs = ListOperations.uniqueSumPairs(numbers, 6);
        System.out.println(pairs);

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println("Sorted capitals by country: " + ListOperations.capitalsSortedByCountry(countries));

        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        System.out.println("Strings starting with char 'a' by length : "
                + ListOperations.stringsSortedByLengthAndFilteredByStartingChar(strings, 'a')
        );

        List<Integer> convertToBin = List.of(1, 2, 3, 4);
        System.out.println("Numbers to binary: " + ListOperations.toBinary(convertToBin));

        List<String> stringsForAlphabet = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Alphabet filtered strings: "
                + ListOperations.sortAndFilterByAlphabet(stringsForAlphabet, alphabet)
        );
    }


}
