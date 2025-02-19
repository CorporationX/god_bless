package school.faang;

import java.util.*;

import static school.faang.ListOperations.findPairs;
import static school.faang.ListOperations.sortedCapitals;

public class Main {

    private static final Set<Integer> integer = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final Map<String, String> strings = new HashMap<>();
    private static final List<String> filter = List.of("banana", "apple", "avokado", "apricot");
    private static final List<Integer> binary = List.of(1, 2, 3, 4, 5, 6);
    private static final List<String> sorted = List.of("apple", "banana", "cherry", "date", "fig", "grape");

    public static void main(String[] args) {

        System.out.println("Двоичный вид: " + ListOperations.binaryForm(binary));

        System.out.println("Фильтр по алфавиту и длине: "
                + ListOperations.sortedAndChar(sorted, "abcdefghijklmnopqrstuvwxyz"));

        System.out.println("Уникальные пары чисел: " + ListOperations.findPairs(integer, 6));

        strings.put("Russia", "Moscow");
        strings.put("USA", "Washington");
        strings.put("Germany", "Berlin");
        System.out.println("Столицы: " + ListOperations.sortedCapitals(strings));

        System.out.println("Сортировк строк: " + ListOperations.filterString(filter, 'a'));

    }
}
