package school.faang.task57988;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Уникальные пары чисел равные {}: {}", 6, Operations.uniqueNums(6, Set.of(1, 2, 3, 4, 5, 6)));
        LOGGER.info("Отсортированные столицы стран: {}", Operations.findSortedCapitals(Map.of("Russia", "Moscow",
                "USA", "Washington", "Germany", "Berlin")));
        LOGGER.info("Отсортированные строки по букве и длине: {}",
                Operations.findSortedWords('a', List.of("apple", "banana", "avocado", "apricot")));
        LOGGER.info("Преобразование чисел в двоичный формат: {}", Operations.findBinaryCodes(List.of(1, 2, 3, 4)));
        LOGGER.info("Фильтрация строк по алфавиту и сортировка по длине: {}",
                Operations.filterWordsAndSort(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                        "acdefghijklmnopqrstuvwxyz"));
    }
}
