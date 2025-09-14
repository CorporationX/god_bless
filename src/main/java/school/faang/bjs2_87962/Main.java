package school.faang.bjs2_87962;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.bjs2_87962.StreamUsing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(findUniqueNumbers(Set.of(1, 2, 3, 4, 5, 6), 6));
        System.out.println(sortCountries(
                Map.of("Russia", "Moscow",
                        "USA", "Washington",
                        "Germany", "Berlin")));
        System.out.println(filterStrings(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(StreamUsing.convertToBinary(List.of(1, 2, 3, 4)));
        System.out.println(StreamUsing.filterAndSortStringsByLength(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"));
    }

}
