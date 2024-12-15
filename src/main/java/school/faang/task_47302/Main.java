package school.faang.task_47302;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        List<Integer> task1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetNumberTask1 = 7;
        System.out.println(taskManager.findPairs(task1, targetNumberTask1));

        Map<String, String> task2 = new HashMap<>();
        task2.put("Russia", "Moscow");
        task2.put("USA", "Washington");
        task2.put("Germany", "Berlin");
        System.out.println(taskManager.onlyCapitals(task2));

        List<String> task3 = Arrays.asList("apple", "banana", "avocado", "apricot");
        char symbolTask3 = 'a';
        System.out.println(taskManager.sortedByLengthAndSymbol(task3, symbolTask3));

        List<Integer> task4 = Arrays.asList(1, 2, 3, 4);
        System.out.println(taskManager.numbersToBinaryFormat(task4));

        List<String> task5 = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabetTask5 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(taskManager.filterAndSortByLength(task5, alphabetTask5));
    }
}
