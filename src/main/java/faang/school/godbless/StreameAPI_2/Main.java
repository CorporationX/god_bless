package faang.school.godbless.StreameAPI_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.StreameAPI_2.CountriesAndCapitals.sortedCountry;
import static faang.school.godbless.StreameAPI_2.FilterOfString.filterChar;
import static faang.school.godbless.StreameAPI_2.PairSum.findingPairsOfNumbers;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9, 5, 3, 6, 4, 5);
        int targetSum = 10;
        List<List<Integer>> pairs = findingPairsOfNumbers(numbers, targetSum);
        System.out.println("Pairs of numbers with sum " + targetSum + " is: " + pairs);

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Poland", "Warsaw");
        countriesAndCapitals.put("France", "Paris");
        countriesAndCapitals.put("Australia", "Canberra");
        countriesAndCapitals.put("Russia", "Moscow");
        List<String> capitals = sortedCountry(countriesAndCapitals);
        System.out.println("Sorted capitals of countries:" + capitals);

        List<String> inputStrings = Arrays.asList("apple", "banana", "123", "dog", "cat", "apricot");
        char alphabet = 'a';
        List<String> filteredAndSortedStrings = filterChar(inputStrings, alphabet);
        System.out.println("Filtered and sorted strings:" + filteredAndSortedStrings);

        HashMap<String, List<String>> friendsGraph = new HashMap<>();
        friendsGraph.put("Alice", List.of("Bob", "Vasia"));
        friendsGraph.put("Bob", List.of("Alice", "Petia"));
        friendsGraph.put("Vasia", List.of("Alice", "Natasha"));
        friendsGraph.put("Petia", List.of("Bob", "Natasha"));
        friendsGraph.put("Natasha", List.of("Чарли", "Petia"));
        List<List<String>> unfriendlyPairs = UnfriendlyPairs.findUnfriendlyPairsUsingStream(friendsGraph);
        System.out.println("Unfriendly pairs is:" + unfriendlyPairs);
    }
}