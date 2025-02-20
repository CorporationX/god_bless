package school.faang.stream2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Training training = new Training();

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int target = 6;
        System.out.println(training.findUniquePairsOfNumbers(numbers, target));

        Map<String, String> countries = Map.of("Russia", "Moscow", "Japan", "Tokyo", "Germany", "Berlin");
        System.out.println(training.sortTheCountries(countries));

        List<String> words = Arrays.asList("banana", "apple", "pineapple", "watermelon");
        char filterChar = 'p';
        System.out.println(training.filteringAndSortingOfStrings(words, filterChar));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(training.convertToBinary(nums));

        List<String> strings = Arrays.asList("apple", "banana", "melon", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(training.filterAndSortByLength(strings, alphabet));
    }
}
