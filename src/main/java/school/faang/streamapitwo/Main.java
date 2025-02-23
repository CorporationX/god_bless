package school.faang.streamapitwo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int sum = 7;

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        ListOperationTwo listOperationsTwo = new ListOperationTwo();

        System.out.println("Уникальные пары чисел " + ListOperationTwo.findPairs(numbers, sum));
        System.out.println("Столицы стран: " + listOperationsTwo.getSortedCapitals(countries));
        System.out.println("Количество строк, начинающихся на 'b': "
                + listOperationsTwo.filterAndSort(strings, 'b'));
        System.out.println("Преобразованные числа в двоичны формат: "
                + listOperationsTwo.convertToBinary(List.of(1, 2, 3, 4)));
        System.out.println("Отсортированные по алфавиту и по длине строки: "
                + listOperationsTwo.filterAndSortByLength(strings, "abcdefghijklmnopqrstuvwxyz"));
    }
}