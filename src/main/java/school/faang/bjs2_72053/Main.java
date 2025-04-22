package school.faang.bjs2_72053;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(14, 10, -4, -3, -2, 2, 0, 1, -1, 13, 4, 5, 8, -5, 11, 12, -6);
        Operations operations = new Operations();
        System.out.println(operations.uniquePairs(numbers, 10));

        Map<String, String> capitals = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        System.out.println(operations.capitals(capitals));

        List<String> strings = List.of("apple", "banana", "vocado", "pricot", "ak");
        System.out.println(operations.stringSort(strings, 'a'));

        List<Integer> forBinary = List.of(1, 2, 3, 4);
        System.out.println(operations.toBinary(forBinary));

        strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println(operations.sortByAlphabet(strings, "bcdfghijklmnopqrstuvwxyz"));
    }
}
