package school.faang.bjs2_88251;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class Runner {
    private static final List<String> DICTIONARY = List.of("air", "animal", "answer", "area", "art",
            "bird", "body", "book", "boy", "brother", "business", "car", "case", "change", "child",
            "children", "city", "class", "color", "community", "company", "country", "day", "death", "dog");
    private static final List<String> SUBSTRINGS = List.of("air", "ani", "re", "art", "ird", "ody",
            "ook", "bo", "other", "ca", "ase", "hil", "ren", "cy", "cl", "olor", "unity", "pan", "da", "eat", "do");
    private static final int COUNT_OF_ELEMENTS = 10;
    private static final char RANDOM_CHAR = (char) ('a' + new Random().nextInt(26));
    private static final int RANDOM_SUBSTRING = new Random().nextInt(SUBSTRINGS.size());
    private static final int MAX_NUMBERS_VALUE = 100_000;

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_ELEMENTS; i++) {
            numbers.add(random.nextInt(MAX_NUMBERS_VALUE));
        }
        log.info("Список чисел: {}", numbers);

        List<String> words = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_ELEMENTS; i++) {
            words.add(DICTIONARY.get(random.nextInt(DICTIONARY.size())));
        }
        log.info("Список слов: {}", words);

        ListOfOperations listOfOperations = new ListOfOperations();
        log.info("Сумма четных чисел: {}", listOfOperations.sumOfEvenNumbers(numbers));
        log.info("Максимальное число списка: {}", listOfOperations.maxNumber(numbers));
        log.info("Среднее значение по списку: {}", listOfOperations.avgNumbersValue(numbers));
        log.info("Количество слов начинающихся на {}: {}", RANDOM_CHAR,
                listOfOperations.wordsStartingWith(words, RANDOM_CHAR));
        log.info("Слова в которых содержится {}: {}", SUBSTRINGS.get(RANDOM_SUBSTRING),
                listOfOperations.containsSubstring(words, SUBSTRINGS.get(RANDOM_SUBSTRING)));
        log.info("Список отсоритрованный по длине слов: {}", listOfOperations.sortedByLength(words));
        log.info("Правда ли что все числа больше {}: {}", MAX_NUMBERS_VALUE / 10,
                listOfOperations.isAllMatch(numbers, integer -> integer > MAX_NUMBERS_VALUE / 10));
        log.info("Наименьшее число кототрое больше {}: {}", MAX_NUMBERS_VALUE / 1488,
                listOfOperations.minBiggerThan(numbers, MAX_NUMBERS_VALUE / 1488));
        log.info("Список длин всех слов: {}", listOfOperations.convertToLength(words));
    }
}

