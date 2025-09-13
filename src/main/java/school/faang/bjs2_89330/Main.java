package school.faang.bjs2_89330;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import static school.faang.bjs2_89330.Practice.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1: Поиск уникальных пар чисел");
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 6;
        List<int[]> pairs = findPairs(numbers, target);
        System.out.println("Пары с суммой " + target + ":");
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
        System.out.println();

        System.out.println("Задача 2: Сортировка стран и столиц");
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> capitals = sortCountries(countries);
        System.out.println("Столицы: " + capitals);
        System.out.println();

        System.out.println("Задача 3: Фильтрация и сортировка строк");
        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';
        List<String> filteredFruits = filter(fruits, startChar);
        System.out.println("Строки на '" + startChar + "': " + filteredFruits);
        System.out.println();

        System.out.println("Задача 4: Преобразование в двоичный формат");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<String> binaryNums = convert(nums);
        System.out.println("Двоичное представление: " + binaryNums);
        System.out.println();
    }
}
