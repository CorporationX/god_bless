package school.faang.streamapi2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(StaticMethods.findPairs(numbers, 10));
        List<String> strings = List.of("apple", "air", "banana", "avocado", "apricot");
        System.out.println(StaticMethods.sortList(strings, 'a'));
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        countries.put("Kazakhstan", "Astana");
        System.out.println(StaticMethods.getCapitals(countries));
        List<Integer> integers = List.of(1, 2, 3, 4);
        System.out.println(StaticMethods.toBinary(integers));
        System.out.println(StaticMethods.filterByAlphabet(strings, "arielp"));
    }
}
