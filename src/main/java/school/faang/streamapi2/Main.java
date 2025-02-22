package school.faang.streamapi2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Map<String, String> countriesWithCapitals = new HashMap<>();
        List<String> words = new ArrayList<>(List.of("apple", "banana", "avocado", "apricot"));
        List<String> wordsAlphabet = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"));
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        countriesWithCapitals.put("Russia", "Moscow");
        countriesWithCapitals.put("USA", "Washington");
        countriesWithCapitals.put("Germany", "Berlin");
        try {
            log.info("Уникальные пары чисел: {} сумма которых равна 6",
                    ServiceOperation.findUniqueEntryNumbers(numbers, 6));
            log.info("Страны по алфавиту и верните список названий их столиц {}",
                    ServiceOperation.sortedCapital(countriesWithCapitals));
            log.info("Фильтр и сортировка списка слов: {}", ServiceOperation.filterSortedWords(words, 'a'));
            log.info("Преобразование чисел в двоичный формат: {}", ServiceOperation.convertToBinary(numbers));
            log.info("Фильтрация строк по алфавиту и сортировка по длине: {}",
                    ServiceOperation.filterAlphabetAndSortedLength(wordsAlphabet, alphabet));
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
        }
    }
}