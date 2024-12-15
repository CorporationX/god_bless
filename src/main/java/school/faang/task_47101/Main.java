package school.faang.task_47101;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 3, 6);
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> alphaStrings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");

        System.out.println("Уникальные пары чисел, сумма которых равна заданному числу (6): "
                + MultiOperations.findPairs(numbers, 6));
        System.out.println("Список названий столиц стран: "
                + MultiOperations.getSortedCapitals(countries));
        System.out.println("Отсортированный по длине список строк, начинающихся с символа 'a': "
                + MultiOperations.filterAndSort(strings, 'a'));
        System.out.println("Список строк, где каждое число записано в двоичном виде: "
                + MultiOperations.convertToBinary(numbers));
        System.out.println("Список строк, отфильтрованный по алфавиту и отсортированный по длине строки: "
                + MultiOperations.filterAndSortByLength(alphaStrings, alphabet));
    }
}
