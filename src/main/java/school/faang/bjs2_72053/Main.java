package school.faang.bjs2_72053;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(14, 10, -4, -3, -2, 2, 0, 1, -1, 13, 4, 5, 8, -5, 11, 12, -6);
        Operations operations = new Operations();
        log.info(operations.uniquePairs(numbers, 10).toString());

        Map<String, String> capitals = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        log.info(operations.capitals(capitals).toString());

        List<String> strings = List.of("apple", "banana", "vocado", "pricot", "ak");
        log.info(operations.stringSort(strings, 'a').toString());

        List<Integer> forBinary = List.of(1, 2, 3, 4);
        log.info(operations.toBinary(forBinary).toString());

        strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        log.info(operations.sortByAlphabet(strings, "bcdfghijklmnopqrstuvwxyz").toString());
    }
}
