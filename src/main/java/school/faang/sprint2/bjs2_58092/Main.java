package school.faang.sprint2.bjs2_58092;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.sprint2.bjs2_58092.ListOfOperations.*;
@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<Integer> nums = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        log.info("Уникальные пары чисел, где сумма 6: {}", findPairs(nums, target));

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        log.info("Результат сортировки и вывода столиц {}", sortAndFindCapital(countries));

        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        log.info("Результат фльтрации и сортировки строк {}", filterAndSort(strings,'a'));

        List<Integer> nums1 = List.of(1, 2, 3, 4, 5, 6);
        log.info("Преобразование чисел в двоичный формат {}", convertToBinary(nums1));

        List<String> strings1 = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        log.info("Фильтрация строк по алфавиту и сортировка по длине {}",
                filterAndSortByLength(strings1, "abcdefghijklmnopqrstuvwxyz"));

    }
}
