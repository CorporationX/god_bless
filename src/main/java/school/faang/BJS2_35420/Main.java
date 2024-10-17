package school.faang.BJS2_35420;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int numForCompare = 7;
        int[] nums = {1, 2, 3, 4, 5, 6};
        List<int[]> pairs = Optinal.findPairsNumbers(nums, numForCompare);
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));

        Map<String, String> countries = new HashMap<>(Map.of("Russia", "Moscow", "USA"
            , "Washington", "Germany", "Berlin"));
        System.out.println(Optinal.sortCountries(countries));

        List<String> strings = new ArrayList<>(List.of("apple", "banana", "avocado", "apricot"));
        String firstCharacter = "a";
        System.out.println(Optinal.filterAndSortStrings(strings, firstCharacter));

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(Optinal.transformationToBinary(numbers));

        List<String> stringsToSort = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"));
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Optinal.sortStringsByAlphabet(stringsToSort, alphabet));

    }

}
