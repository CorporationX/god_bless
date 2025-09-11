package school.faang.bjs2_87900;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(ListOperation.findPairs(Set.of(1, 2, 3, 4, 5, 6), 6));
        Map<String, String> mapCountry = new HashMap<>() {{
                put("Russia", "Moscow");
                put("USA", "Washington");
                put("Germany", "Berlin");
            }};
        System.out.println(ListOperation.getSortedCountry(mapCountry));

        System.out.println(ListOperation.getSortedStrings(List.of("apple", "banana", "avocado", "apricot"), 'a'));

        System.out.println(ListOperation.convertToBinary(List.of(1, 2, 3, 4)));

        System.out.println(ListOperation
                .getSortedByAlphabet(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                        "abcdefghijklmnopqrstuvwxyz"));
    }
}
