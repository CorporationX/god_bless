package school.faang.streamApiSecond;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StreamService streamService = new StreamService();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer target = 7;
        Set<List<Integer>> groupedNumbers = streamService.getGropedNumbers(numbers, target);
        System.out.println("Grouped Numbers: " + groupedNumbers);

        Map<String, String> countriesWithCapitals = new HashMap<>();
        countriesWithCapitals.put("France", "Paris");
        countriesWithCapitals.put("Germany", "Berlin");
        countriesWithCapitals.put("Spain", "Madrid");
        List<String> sortedCapitals = streamService.sortByAlphabet(countriesWithCapitals);
        System.out.println("Sorted Capitals: " + sortedCapitals);

        List<Integer> decimalNumbers = Arrays.asList(2, 3, 4, 5, 10);
        List<String> binaryNumbers = streamService.convertToBinary(decimalNumbers);
        System.out.println("Binary Numbers: " + binaryNumbers);

        List<String> words = Arrays.asList("apple", "banana", "kiwi", "pear", "peach");
        String alphabet = "aeiou";
        List<String> filteredWords = streamService.filterWordsByLengthAndAlphabet(words, alphabet);
        System.out.println("Filtered Words: " + filteredWords);
    }
}

