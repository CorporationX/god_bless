package school.faang.sprint_2.task_43543;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(StreamTrainingTasks.findPairs(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)), 7));
        System.out.println(StreamTrainingTasks.getSortedCapitals(new HashMap<>(
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"))));
        System.out.println(StreamTrainingTasks.filterAndSort(new ArrayList<>(
                List.of("apple", "banana", "avocado", "apricot", "cherry")), 'a'));
        System.out.println(StreamTrainingTasks.convertToBinary(new ArrayList<>(List.of(14, 85, 123, 789))));
        System.out.println(StreamTrainingTasks.filterAndSortByLength(new ArrayList<>(List.of(
                "apple", "banana", "cherry", "date", "fig", "grape")), "abcdefghijklmnopqrstuvwxyz"));
    }
}