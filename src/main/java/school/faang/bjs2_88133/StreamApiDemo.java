package school.faang.bjs2_88133;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class StreamApiDemo {
    public static void main(String[] args) {
        System.out.println("1) Уникальные пары с суммой target");

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 6;
        Set<Set<Integer>> pairs = StreamApi.findUniquePairsWithSum(numbers, target);
        List<List<Integer>> prettyPairs = pairs.stream()
                .map(s -> s.stream().sorted().collect(Collectors.toList()))
                .sorted(Comparator.comparing((List<Integer> p) -> p.get(0)))
                .collect(Collectors.toList());
        System.out.println("Вход: " + numbers + ", target=" + target);
        System.out.println("Выход: " + prettyPairs);

        System.out.println("\n" + "2) Столицы по странам, отсортированным по алфавиту");

        Map<String, String> countryCapital = new LinkedHashMap<>();
        countryCapital.put("Russia", "Moscow");
        countryCapital.put("USA", "Washington");
        countryCapital.put("Germany", "Berlin");
        List<String> capitals = StreamApi.capitalsByCountrySorted(countryCapital);
        System.out.println("Вход: " + countryCapital);
        System.out.println("Выход: " + capitals);

        System.out.println("\n" + "3) Строки на букву 'a' + сортировка по длине");

        List<String> words = Arrays.asList("apple", " banana", "Avocado", null, " apricot", "pear", "", "  ");
        char ch = 'a';
        List<String> filteredA = StreamApi.filterStartingWithAndSortByLength(words, ch);
        System.out.println("Вход: " + words + ", ch='" + ch + "'");
        System.out.println("Выход: " + filteredA);

        System.out.println("\n" + "4) В двоичный формат");

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 0);
        List<String> bins = StreamApi.toBinaryStrings(ints);
        System.out.println("Вход: " + ints);
        System.out.println("Выход: " + bins);

        System.out.println("\n" + "5) Фильтр по алфавиту + сортировка по длине");

        List<String> words2 = Arrays.asList("Apple", "banana", "cherry", "date", "fig", "grape", "tea-42", "кошка");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredByAlphabet = StreamApi.filterByAlphabetAndSortByLength(words2, alphabet);
        System.out.println("Вход: " + words2 + ", alphabet=\"" + alphabet + "\"");
        System.out.println("Выход: " + filteredByAlphabet);
    }
}
