package school.faang.streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListOperations listOperations = new ListOperations();

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<int[]> pairs = listOperations.findUniquePairs(numbers, 6);
        System.out.println("Уникальные пары чисел: ");
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));

        Map<String, String> countryCapitals = new HashMap<>();
        countryCapitals.put("Russia", "Moscow");
        countryCapitals.put("USA", "Washington");
        countryCapitals.put("Germany", "Berlin");
        List<String> capitals = listOperations.getSortedCapitals(countryCapitals);
        System.out.printf("\nОтсортированные столицы: \n - %s", capitals);

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> filteredStrings = listOperations.filterAndSort(strings, 'a');
        System.out.printf("\nОтфильтрованные и отсортированные строки: \n - %s", filteredStrings);

        List<Integer> numbersToConvert = Arrays.asList(1, 2, 3, 4);
        List<String> binaryNumbers = listOperations.convertToBinary(numbersToConvert);
        System.out.printf("\nЧисла в двоичном формате: \n - %s", binaryNumbers);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        List<String> filteredWords = listOperations
                .filterAndSortByAlphabet(words, "abcdefghijklmnopqrstuvwxyz");
        System.out.printf("\nОтфильтрованные и отсортированные слова: \n - %s", filteredWords);
    }
}
