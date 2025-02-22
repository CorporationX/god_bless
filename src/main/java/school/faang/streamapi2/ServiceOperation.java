package school.faang.streamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ServiceOperation {

    public static Map<Integer, Integer> findUniqueEntryNumbers(List<Integer> numbers, int numberSum) {
        validateList(numbers);
        return numbers.stream()
                .distinct()
                .filter(number -> numbers.contains(numberSum - number)
                        && number != (numberSum - number)
                        && number < (numberSum - number))
                .collect(Collectors.toMap(number -> number, number -> numberSum - number));
    }

    public static List<String> sortedCapital(Map<String, String> countriesWithCapitals) {
        validateArgument(countriesWithCapitals);
        return countriesWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> filterSortedWords(List<String> words, char symbol) {
        validateList(words);
        return words.stream().filter(word -> word.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        validateList(numbers);
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAlphabetAndSortedLength(List<String> words, String alphabet) {
        validateArgument(alphabet);
        validateList(words);
        List<Character> charsAlphabet = alphabet.chars().mapToObj(symbol -> (char) symbol).toList();
        return words.stream().filter(word -> word.chars().mapToObj(letter -> (char) letter)
                        .allMatch(charsAlphabet::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static <T> void validateList(List<T> list) {

        Objects.requireNonNull(list, "Список не может быть пустым");
    }

    private static <U> void validateArgument(U argument) {
        if (argument instanceof String && ((String) argument).isBlank()) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }
        Objects.requireNonNull(argument, "Аргумент не может быть null");
    }
}