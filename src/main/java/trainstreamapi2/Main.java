package trainstreamapi2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        System.out.println("Уникальные пары: " + Operations.findUniquePairs(numbers, target));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println("Столицы по алфавиту стран: " + Operations.sortCountriesAndPrintCapitals(countries));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        char start = 'a';
        System.out.println("Строки на '" + start + "': " + Operations.filterAndSortStrings(fruits, start));

        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println("Двоичный формат: " + Operations.convertNumbersToBinary(nums));

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Слова из алфавита: " + Operations.filterAndSortByLength(words, alphabet));
    }
}
