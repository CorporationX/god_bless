package school.faang.stream2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Operation.uniquePairNumbers(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 8));

        Map<String, String> map = new HashMap<>();
        map.put("Russia", "Moscow");
        map.put("USA", "Washington");
        map.put("Deutschland", "Berlin");
        System.out.println(Operation.sortCountiesAndOutputCapitals((map)));

        System.out.println(Operation.filterAndSortString(List.of("apple", "banana", "avocado", "apricot"), 'a'));

        System.out.println(Operation.convertNumbersToBinary(List.of(7, 15, 11, -4, 2)));

        System.out.println(Operation.alphabetically(List.of("aplle", "banana", "date"), "bandate"));
    }
}
