package school.faang.stream_optional.bjs2_87992;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Operations operations = new Operations();

        //Найдите уникальные пары чисел

        System.out.println(operations.getPairsThatSumEqualsArgument(7, Set.of(1, 2, 3, 4, 5, 6)));

        //Отсортируйте страны и выведите столицы
        Map<String, String> map = new HashMap<>();
        map.put("Russia", "Moscow");
        map.put("USA", "Washington");
        map.put("Germany", "Berlin");

        System.out.println(operations.getSortedMapValues(map));

        //Фильтрация и сортировка строк
        System.out.println(operations
                .filterByChar(Arrays.asList("apple", "banana", "avocado", "apricot"), 'a'));

        //Преобразование чисел в двоичный формат
        System.out.println(operations.getBinaryFormat(Arrays.asList(1, 2, 3, 4)));

        //Фильтрация строк по алфавиту и сортировка по длине
        List<String> filteredFruits = operations.filterByAllWordCharsContainsInString(Arrays
                .asList("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz");
        System.out.println(filteredFruits);
    }
}