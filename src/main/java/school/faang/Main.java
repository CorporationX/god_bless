package school.faang;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Integer> set = Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum = 7;
        Set<List<Integer>> result1 = StreamOperations.findPairs(set, sum);
        System.out.printf("Список элементов: %s\nСумма пар: %s\nПары элементов: %s\n\n", set, sum, result1);

        Map<String, String> countriesWithCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin",
                "Italy", "Rome");
        List<String> result2 = StreamOperations.filtrateCapitals(countriesWithCapitals);
        System.out.printf("Страны со столицами: %s\nСтолицы: %s\n\n", countriesWithCapitals, result2);

        List<String> strings = List.of("apple", "banana", "avocado", "apricot", "coconut", "mango");
        char character = 'a';
        List<String> result3 = StreamOperations.filtrateByLengthStartsWithCharacter(strings, character);
        System.out.printf("Изначальный список строк: %s\nПервая буква: %s\nОтсортированные строки: %s\n\n",
                strings, character, result3);

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> result4 = StreamOperations.turn10to2(nums);
        System.out.printf("Список десятичных элементов: %s\nСписок двоичных элементов: %s\n\n", nums, result4);

        List<String> strings1 = List.of("apple", "banana", "avocado", "apricot", "coconut", "mango",
                "яблоко", "виноград", "апельсин");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result5 = StreamOperations.filtrateByLengthContainingAlphabet(strings1, alphabet);
        System.out.printf("Изначальный список: %s\nИспользующийся алфавит: %s\nПолученный список: %s\n\n",
                strings1, alphabet, result5);
    }
}
