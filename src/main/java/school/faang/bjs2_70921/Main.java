package school.faang.bjs2_70921;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Задача "Потренируем StreamAPI 2"
 */
public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(6, 5, 4, 3, 2, 1);
        Map<String, String> capitals = new HashMap<>(Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin",
                "Belarus", "Minsk"
        ));
        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> fruits2 = Arrays.asList("apple", "cherry", "banana", "date", "fig", "grape");

        System.out.printf("Пары чисел: %s%n", StreamOperations.getPairs(numbers, 6).toString());
        System.out.printf("Столицы: %s%n", StreamOperations.sortCapitalsMap(capitals).toString());
        System.out.printf("Начинаются с 'a' и отсортированы по длине: %s%n",
                StreamOperations.getStartWithPrefixAndSortedByLength(fruits, "a").toString());
        System.out.printf("Числа в двоичном формате: %s%n",
                StreamOperations.convertIntToBinString(List.of(6, 5, 4, 3, 2, 1)).toString());
        System.out.printf("Фильтр по алфавиту и сортировка по длине: %s%n",
                StreamOperations.filterByAlphabetAndSortByLength(fruits2,
                        "aabcdefghijklmnopqrstuvwxyz").toString());
    }
}
