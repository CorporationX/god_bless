package school.faang.stream_api;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(StreamHandler.findUniquePairs(Set.of(1, 2, 3, 4, 5, 6), 6));
        System.out.println(StreamHandler.getCapitals(Map.of("Russia", "Moscow", "USA", "Washington",
                "Germany", "Berlin")));
        System.out.println(StreamHandler.transferList(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(StreamHandler.transferToBinaryFormat(List.of(1, 2, 3, 4)));
        System.out.println(StreamHandler.filterAndSort(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"));
    }
}
