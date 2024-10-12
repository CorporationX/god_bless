package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StreamingOperations streamingOperations = new StreamingOperations();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Map<String, String> countries = new HashMap<>();
        countries.put("Spain", "Madrid");
        countries.put("Portugal", "Lisbon");
        countries.put("Netherlands", "Amsterdam");
        countries.put("Sweden", "Stockholm");
        countries.put("Poland", "Warsaw");
        List<String> words = List.of("Crowd", "Age", "Gold", "Adult", "Skinny", "Chaos", "God", "General", "Body");
        String alphabet = "abcdefghijklmnop";

        System.out.println("Input: " + numbers + ", Target value: " + 9);
        System.out.println("Output: " + streamingOperations.findUniquePairs(numbers, 9));
        System.out.println("Input: " + countries);
        System.out.println("Output: " + streamingOperations.sortCountries(countries));
        System.out.println("Input: " + words + ", First character: " + 'G');
        System.out.println("Output: " + streamingOperations.filterAndSort(words, 'G'));
        System.out.println("Input: " + numbers);
        System.out.println("Output: " + streamingOperations.convertNumbersToBinary(numbers));
        System.out.println("Input: " + words + ", Alphabet: " + alphabet);
        System.out.println("Output: " + streamingOperations.filterByAlphabetAndSortByLength(words, alphabet));
    }
}
