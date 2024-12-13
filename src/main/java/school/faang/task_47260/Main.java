package school.faang.task_47260;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 7;

        Set<List<Integer>> pairs = Data.findPairs(numbers, sum);
        System.out.println("Найденные пары с суммой " + sum + ":");
        pairs.forEach(System.out::println);

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        List<String> sortedCapitals = Data.getSortedCapitals(countries);
        System.out.println(sortedCapitals);

        List<String> words = Arrays.asList("melon", "apple", "banana", "avocado", "apricot", "tomato");
        char letter = 'a';

        List<String> result = Data.filterAndSort(words, letter);
        result.forEach(System.out::println);

        System.out.println("Переводим в двоичную систему: " + numbers);
        List<String> binary = Data.listStringBinary(numbers);
        binary.forEach(System.out::println);

        List<String> words1 = Arrays.asList("melon", "apple", "banana", "avocado", "Apricot", "Tomato");
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("строки, которые содержат только буквы из заданного алфавита: ");
        List<String> output = Data.listStringFilter(words1, alfabet);
        output.forEach(System.out::println);
    }
}





