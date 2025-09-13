package school.faang.bjs2_87944;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Set<Integer> someNumbers = Set.of(1, 2, 3, 4, 5, 6, 7);
        Set<Map.Entry<Integer, Integer>> uniquePairs = findUniqueSumPairs(someNumbers, 7);
        System.out.printf("Уникальные пары, сумма которых равна %d: %s\n\n", 7, uniquePairs);

        List<String> someBinaryNumbers = turnNumbersToBinaryFormat(new ArrayList<>(someNumbers));
        System.out.printf("Числа %s в двоичном формате: %s\n\n", someNumbers, someBinaryNumbers);

        Map<String, String> countriesAndCapitals = Map.of(
                "Россия", "Москва",
                "Китай", "Пекин",
                "Великобритания", "Лондон",
                "США", "Вашингтон",
                "Индия", "Нью-Дэли"
        );
        List<String> capitals = sortAlphabeticAndGetValues(countriesAndCapitals);
        System.out.printf("Карта Стран и Столиц отсортирована по алфавиту.\nСтолицы: %s\n\n", capitals);

        List<String> someWords = List.of(
                "банан", "барабан", "баран", "баклажан",
                "маринад", "миллиард", "миад", "микрофарад"
        );
        List<String> filteredAndSortedWords = filterByCharAndSortByLength(someWords, 'б');
        System.out.printf("Отсортированные по длине слова, которые начинаются на %c: %s\n\n",
                'б', filteredAndSortedWords);

        List<String> someJunglePredators = List.of("тигр", "буйвол", "ягуар", "аннаконда", "бегемот", "крокодил");
        List<String> filteredAndSortedPredators = filterAlphabeticAndSortByLength(someJunglePredators,
                "абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        System.out.printf("Отфильтрованные по заданному алфавиту и отсортрованные по длине слов хищники: %s\n\n",
                filteredAndSortedPredators);
    }

    public static Set<Map.Entry<Integer, Integer>> findUniqueSumPairs(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(number -> {
                    int pairNum = targetNumber - number;
                    return number + number != targetNumber
                            && numbers.contains(pairNum)
                            && number < pairNum;
                })
                .map(number -> Map.entry(number, targetNumber - number))
                .collect(Collectors.toSet());
    }

    public static List<String> turnNumbersToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortAlphabeticAndGetValues(Map<String, String> pairs) {
        return pairs.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted()
                .toList();
    }

    public static List<String> filterByCharAndSortByLength(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(Character.toString(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> filterAlphabeticAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
