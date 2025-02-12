package school.faang.streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 6;
        List<int[]> result = Solution.findUniquePairs(numbers, target);
        String output = result.stream()
                .map(pair -> "(" + pair[0] + ", " + pair[1] + ")")
                .collect(Collectors.joining(", "));
        System.out.println("Найденные пары: " + output);

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        List<String> capitals = Solution.getSortedCapitals(countries);
        System.out.println("Столицы, отсортированные по странам: " + capitals);

        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        char filterChar = 'a';
        List<String> filteredSorted = Solution.filterAndSortByChar(words, filterChar);
        System.out.println("Строки, начинающиеся на '" + filterChar + "', отсортированные по длине: " + filteredSorted);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<String> binaryNumbers = Solution.convertNumbersToBinary(nums);
        System.out.println("Числа в двоичном формате: " + binaryNumbers);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String allowedAlphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredFruits = Solution.filterByAlphabetAndSort(fruits, allowedAlphabet);
        System.out.println("Строки, содержащие символы только из алфавита, отсортированные по длине: " + filteredFruits);
    }
}
