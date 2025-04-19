package school.faang.train_stream_api_2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 7;
        log.info("1️⃣ Найдите уникальные пары чисел {}",
                ListOperations.uniqueCouples(numbers, target));

        Map<String, String> countries = new HashMap<>() {{
                put("Germany", "Berlin");
                put("France", "Paris");
                put("Italy", "Rome");
                put("Spain", "Madrid");
                }};

        log.info("2️⃣ Отсортируйте страны и выведите столицы {}",
                ListOperations.getCapitalsSortedByCountry(countries));

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        log.info("3️⃣ Фильтрация и сортировка строк, начинающихся на 'a': {}",
                ListOperations.filteringAndSortingLines(strings, "ap"));

        List<Integer> numbers2 = Arrays.asList(19, 2, 3, 4, 5, 6, 9, 10, 13, 14, 19);
        log.info("4️⃣ Преобразование чисел в двоичный формат : {}",
                ListOperations.transformationOfNumbersIntoBinaryFormat(numbers2));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        log.info("5️⃣ Фильтрация строк по алфавиту и сортировка по длине : {}",
                ListOperations.filterAndSortByAlphabetAndLength(words,
                        "abcdefghijklmnopqrstuvwxyz"));
    }
}
