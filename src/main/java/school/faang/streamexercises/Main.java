package school.faang.streamexercises;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = IntStream.rangeClosed(1, 8)
                .boxed()
                .collect(Collectors.toSet());
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "France", "Paris",
                "Germany", "Berlin",
                "Italy", "Rome"
        );
        List<String> strings = List.of(
                "apple",
                "banana",
                "avocado",
                "apricot",
                "cherry",
                "fig",
                "grape"
        );
        System.out.println("Уникальные пары чисел: " + Operations.findUniquePairs(numbers, 8));
        System.out.println("Столицы: " + Operations.sortCapitalsByCountry(countries));
        System.out.println("Строки, начинающиеся с 'a': " + Operations.filterAndSortStrings(strings, 'a'));
        System.out.println("Числа в двоичном формате: " + Operations.convertToBinaryStrings(numbers));
        System.out.println("Строки по алфавиту и длине: "
                + Operations.filterByAlphabetAndSortByLength(strings, "abcdefghijklmnopqrstuvwxyz"));
    }
}