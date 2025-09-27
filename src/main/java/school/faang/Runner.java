package school.faang;

 svxrslf-BJS2-91101
public class Runner {

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Slf4j
public class Runner {
    private static final Map<String, String> CAPITAL_OF_COUNTRIES = Map.of(
            "Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
    private static final List<String> DICTIONARY = List.of("air", "animal", "answer", "area", "art",
            "bird", "body", "book", "boy", "brother", "business", "car", "case", "change", "child",
            "children", "city", "class", "color", "community", "company", "country", "day", "death", "dog");
    private static final int COUNT_OF_ELEMENTS = 10;
    private static final char RANDOM_CHAR = (char) ('a' + new Random().nextInt(26));
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private static final int MAX_NUMBERS_VALUE = 100;

    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < COUNT_OF_ELEMENTS; i++) {
            numbers.add(random.nextInt(MAX_NUMBERS_VALUE));
        }
        log.info("Множество чисел: {}", numbers);

        List<String> words = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_ELEMENTS; i++) {
            words.add(DICTIONARY.get(random.nextInt(DICTIONARY.size())));
        }
        log.info("Список слов: {}", words);

        ListOfOperations operations = new ListOfOperations();
        log.info("Уникальные пары чисел: {}", operations.findPairs(numbers, 100));
        log.info("Столицы стран: {}", operations.findCapital(CAPITAL_OF_COUNTRIES));
        log.info("Слова которые начинаются на букву {}: {}", RANDOM_CHAR,
                operations.startsWithChar(words, RANDOM_CHAR));
        log.info("Числа из списка в двоичной системе: {}", operations.toBinary(numbers));
        log.info("Строки отфильтованные по алфавиту и отсортированные по длине: {}",
                operations.filterThenSortByLength(words, ALPHABET));

    }
 svxrslf
}
