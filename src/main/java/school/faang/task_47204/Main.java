package school.faang.task_47204;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int number = 7;
        findUnicPairs(numbers, number);

        HashMap<String, String> countries = new HashMap<String, String>() {{
            put("Russia", "Moscow");
            put("USA", "Washington");
            put("Germany", "Berlin");
        }};
        outAllCapitals(countries);

        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        char letter = 'a';
        findWordsBeginOn(words, letter);

        List<Integer> numbersToD = Arrays.asList(1, 2, 3, 4);
        numbersToAnotherSystem(numbersToD);

        List<String> wordsFilter = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "[" + "abcdefghijklmnopqrstuvwxyz" + "]+";
        filterWordsAndSort(wordsFilter, alphabet);
    }

    private static void filterWordsAndSort(List<String> wordsFilter, String alphabet) {
        List<String> words = wordsFilter.stream().filter(word -> word.matches(alphabet)).sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(words);
    }

    private static void numbersToAnotherSystem(List<Integer> numbersToD) {
        List<String> numbersAnother = numbersToD.stream().map(Integer::toBinaryString).toList();
        System.out.println(numbersAnother);
    }

    private static void findWordsBeginOn(List<String> words, char letter) {
        List<String> wordsList = words.stream().filter(word -> word.startsWith(Character.toString(letter))).collect(Collectors.toList());
        System.out.println(wordsList);
    }

    private static void outAllCapitals(HashMap<String, String> countries) {
        List<String> capitals = countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());

        System.out.println(capitals);
    }

    private static void findUnicPairs(List<Integer> numbers, int number) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        pairs = numbers.stream()
                .filter(num -> set.contains(number - num))
                .map(num -> Arrays.asList(num, number - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        System.out.println(pairs);
    }
}
