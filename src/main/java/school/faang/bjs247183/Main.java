package school.faang.bjs247183;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                ListOperations.findPairs(
                        List.of(1, 2, 3, 4, 5, 6), 7));
        System.out.println(
                ListOperations.filterCountry(
                        Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));
        System.out.println(
                ListOperations.filterAndSortWords(
                        List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(
                ListOperations.toBinary(
                        List.of(1, 2, 3, 4)));
        System.out.println(
                ListOperations.filterAndSortByLength(
                        List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                        "abcdefghijklmnopqrstuvwxyz"));
    }
}
