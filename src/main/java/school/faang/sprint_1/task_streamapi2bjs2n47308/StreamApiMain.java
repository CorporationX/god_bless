package school.faang.sprint_1.task_streamapi2bjs2n47308;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class StreamApiMain {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, String> countries = new TreeMap<>() {{
                    put("Russia", "Moscow");
                    put("USA", "Washington");
                    put("Germany", "Berlin");
            }};

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        List<String> words = List.of("apple", "banana", "avocado", "apricot", "date", "fig", "grape");
        char startChar = 'b';
        String alphabet = "bcvanod";

        log.info("Пары чисел, сумма которых равна {}: {}", 9, Operations.findPairs(numbers, 9));
        log.info("Отсортированный Map стран: {}", countries);
        log.info("Отсортируйте страны и выведите столицы : {}", Operations.sortedCapitalsOfCountries(countries));
        log.info("Строки, начинающиеся с \"{}\": {} ", startChar, Operations.filterStrings(fruits, startChar));
        log.info("Числа в двоичном формате: {} ", Operations.toBinaryString(numbers));
        log.info("Отфильтрованные строки по алфавиту {}: {}", alphabet, Operations.filterByAlphabet(words, alphabet));
    }
}
