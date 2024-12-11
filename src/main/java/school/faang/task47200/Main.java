package school.faang.task47200;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(
                15, 2, 59, 3, 7, 10, -42
        ));

        try {
            System.out.println(sumUniqueNumbers(numbers, 17));

            Map<String, String> countriesAndCapitals = new HashMap<>(Map.of(
                    "Russia", "Moscow",
                    "USA", "Washington",
                    "Germany", "Berlin"
            ));

            System.out.println(namesOfCapitals(countriesAndCapitals));

            List<String> strings = new ArrayList<>(List.of("apple", "banana", "avocado", "apricot"));

            System.out.println(filterSortStrings(strings, 'a'));

            numbers = new ArrayList<>(List.of(1, 2, 3, 5));

            System.out.println(conversionToBinaryFormat(numbers));

            strings = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"));

            System.out.println(containsCharacterAndSortByLength(strings, "abcdehjklmnopqrstuvwxyz"));
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
    }

    private static <T> void validateList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Список пуст");
        }
    }

    private static List<List<Integer>> sumUniqueNumbers(List<Integer> numbers, int targetNumber) {
        validateList(numbers);

        if (numbers.stream().mapToInt(Integer::intValue).sum() < targetNumber) {
            throw new IllegalArgumentException("Сумма чисел не может быть меньше чем заданное число");
        }

        List<Integer> sortedList = numbers.stream().sorted().toList();
        Map<Integer, Integer> pairNumbers = new HashMap<>();

        sortedList.forEach(number -> {
            sortedList.stream()
                    .filter(number2 -> number + number2 == targetNumber && number2 >= number)
                    .forEach(number2 -> pairNumbers.putIfAbsent(number, number2));
        });

        List<List<Integer>> resultList = new ArrayList<>();

        if (pairNumbers.isEmpty()) {
            throw new IllegalArgumentException("В списке нет чисел которые бы давали сумму равную " + targetNumber);
        }

        pairNumbers.forEach((key, value) -> resultList.add(List.of(key, value)));

        return resultList;
    }

    private static List<String> namesOfCapitals(Map<String, String> countriesAndCapitals) {
        if (countriesAndCapitals == null || countriesAndCapitals.isEmpty()) {
            throw new IllegalArgumentException("countriesAndCapitals не должен быть пустым либо равным null");
        }

        return countriesAndCapitals.keySet().stream()
                .sorted()
                .map(countriesAndCapitals::get)
                .toList();
    }

    private static List<String> filterSortStrings(List<String> words, char character) {
        validateList(words);

        return words.stream()
                .filter(word -> word.isEmpty() || word.charAt(0) == character)
                .sorted()
                .toList();
    }

    private static List<String> conversionToBinaryFormat(List<Integer> numbers) {
        validateList(numbers);

        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    private static List<String> containsCharacterAndSortByLength(List<String> words, String alphabet) {
        validateList(words);
        if (alphabet == null || alphabet.isBlank()) {
            throw new IllegalArgumentException("alphabet не должен быть пустым");
        }

        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .filter(word -> word.chars()
                        .mapToObj(character -> String.valueOf((char) character))
                        .anyMatch(alphabet::contains)).toList();
    }
}
