package ru.kraiush.BJS2_35224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static ru.kraiush.BJS2_35224.ListOperations.filterStringsByAlphabetAndLength;
import static ru.kraiush.BJS2_35224.ListOperations.filterStringsStartingWithCharAndSortByLength;
import static ru.kraiush.BJS2_35224.ListOperations.findUniqueSums;
import static ru.kraiush.BJS2_35224.ListOperations.getCapitalsOrderedByAlphabet;
import static ru.kraiush.BJS2_35224.ListOperations.mapToBinaryFromDecimal;

public class Main {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Unique pairs which sum is 7:");
        findUniqueSums(nums, 7).forEach(array -> System.out.println(Arrays.toString(array)));

        Map<String, String> countriesCapitals= Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println("Capitals ordered by alphabet: " + getCapitalsOrderedByAlphabet(countriesCapitals));

        List<String> strings = new ArrayList<>(Arrays.asList("apple", "banana", "avocado", "apricot"));
        System.out.println("Strings starting with 'a' and sorted by length: " + filterStringsStartingWithCharAndSortByLength(strings, 'a'));

        List<Integer> decimalNums = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("Binary numbers: " + mapToBinaryFromDecimal(decimalNums));

        List<String> words = new ArrayList<>(Arrays.asList("apple", "банан", "banana", "cherry", "date", "fig", "grape"));
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Filtered and sorted words: " + filterStringsByAlphabetAndLength(words, alphabet));
    }
}
