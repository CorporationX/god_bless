package school.faang.task_57833;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        final Map<String, String> map = Map.of("Russia", "Moscow",
                "USA", "Washington", "Germany", "Berlin");
        final List<String> list = List.of("apple", "banana", "avocado", "apricot");
        final List<Integer> list2 = List.of(1, 2, 3, 4);
        final List<String> list3 = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        System.out.println("Task 1:");
        Operations.uniquePairs(set, 6).forEach(System.out::println);
        System.out.println();
        System.out.println("Task 2:");
        Operations.getCapitals(map).forEach(System.out::println);
        System.out.println();
        System.out.println("Task 3:");
        Operations.filterAndSortStrings(list, 'a').forEach(System.out::println);
        System.out.println();
        System.out.println("Task 4:");
        Operations.convertToBinary(list2).forEach(System.out::println);
        System.out.println();
        System.out.println("Task 5:");
        Operations.filterAndSortByLength(list3)
                .forEach(System.out::println);
    }
}
