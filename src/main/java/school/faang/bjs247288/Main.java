package school.faang.bjs247288;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetNumber = 7;
        System.out.println("Уникальные пары чисел: ");
        System.out.println(ListOperations.uniquePairsOfNumbers(numbers, targetNumber));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        System.out.println();
        System.out.println("Названий их столиц, отсортированных стран по алфавиту :");
        System.out.println(ListOperations.getSortedCapitals(countries));

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println();
        System.out.println("Отсортированные строки по длине, которые начинаются с символа 'a'");
        ListOperations.filterAndSort(strings, 'a').forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println();
        System.out.println("Cписок строк, где каждое число записано в двоичном виде:");
        ListOperations.convertToBinary(nums).forEach(System.out::println);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println();
        System.out.println("Отсортированные строки по длине, которые содержат только буквы из заданного алфавита: ");
        ListOperations.filterAndSortByLength(fruits, alphabet).forEach(System.out::println);
    }
}
