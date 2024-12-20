package faang.school.godbless.sprint_2.task_47372;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("USA", "Washington");
        countriesAndCapitals.put("Germany", "Berlin");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<String> fruits = List.of("apple", "banana", "cherry", "date", "fig", "grape", "apricot");

        System.out.println("Уникальные пары чисел: "
                + CollectionOperations.findUniquePairs(numbers, 7));

        System.out.println("Столицы стран: "
                + CollectionOperations.sortCountriesAndReturnCapitals(countriesAndCapitals));

        System.out.println("Отфильтрованные и отсортированные строки: "
                + CollectionOperations.filterAndSortByChar(fruits, 'a'));

        System.out.println("Числа, преобразованные в двоичный формат: "
                + CollectionOperations.convertToBinaryFormat(numbers));

        System.out.println("Строки, отфильтрованные по алфавиту и отсортированные по длине: "
                + CollectionOperations.filterAlphabeticallyAndSortByLength(fruits,
                "abcdefghijklmnopqrstuvwxyz"));
    }
}
