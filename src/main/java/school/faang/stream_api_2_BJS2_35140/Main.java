package school.faang.stream_api_2_BJS2_35140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int numForCompare = 7;
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(Operator.findPairsNumbers(numbers, numForCompare));

        Map<String, String> countries = new HashMap<>(Map.of("Russia", "Moscow", "USA"
                , "Washington", "Germany", "Berlin"));
        System.out.println(Operator.sortCountries(countries));

        List<String> strings = new ArrayList<>(List.of("apple", "banana", "avocado", "apricot"));
        char firstCharacter = 'a';
        System.out.println(Operator.filterAndSortStrings(strings, firstCharacter));

        System.out.println(Operator.transformationToBinary(numbers));

        List<String> stringsToSort = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"));
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Operator.sortStringsByAlphabet(stringsToSort, alphabet));

    }

}
