package faang.school.godbless.streamapi.streamapi2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(ListUtility.findPairsWithSpecificSum(List.of(1, 2, 3, 4, 5, 6, 7), 7));
        System.out.println(ListUtility.findPairsWithSpecificSum(List.of(1), 1));
        System.out.println(ListUtility.findPairsWithSpecificSum(List.of(1, 2), 1));
        System.out.println(ListUtility.findPairsWithSpecificSum(List.of(1, 2), 2));
        System.out.println(ListUtility.findPairsWithSpecificSum(List.of(1, 2, 3), 2));


        System.out.println(ListUtility.getSortedCapitals(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));


        System.out.println(ListUtility.findAndSortStringStartWithSymbol(List.of("apple", "banana", "avocado", "apricot"), 'a'));


        System.out.println(ListUtility.toBinary(List.of(1, 2, 3, 4)));


        System.out.println(ListUtility.getSortedStringsByLengthFromAlphabet(
                List.of("1", ".", "a1", "apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"));
    }
}
