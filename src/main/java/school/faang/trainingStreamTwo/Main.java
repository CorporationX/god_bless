package school.faang.trainingStreamTwo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> setNumber = Set.of(1, 4, 6, 2, 7, 3, 5);
        System.out.println(Training.sumNumber(setNumber, 6));
        System.out.println(Training.converter(setNumber.stream().toList()));

        Map<String, String> mapCountry = new HashMap<>();
        mapCountry.put("Russia", "Moscow");
        mapCountry.put("USA", "Washington");
        mapCountry.put("Germany", "Berlin");
        System.out.println(Training.sortedCountry(mapCountry));

        List<String> words = List.of("apple", "banana", "avocado", "apricot",
                "cherry", "date", "fig", "grape");
        System.out.println(Training.filterAndSorted(words, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(Training.sortedList(words, 'a'));
    }
}
