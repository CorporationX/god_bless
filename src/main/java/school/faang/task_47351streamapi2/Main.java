package school.faang.task_47351streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = 7;
        Set<List<Integer>> set = ListOperations.findPairs(list, sum);
        System.out.println("Найдены пары с суммой " + sum + ":");
        set.forEach(System.out::println);

        Map<String, String> countries  = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        List<String> sortedCapitals = ListOperations.getSortedCapitals(countries);
        System.out.println(sortedCapitals);

        List<String> length = Arrays.asList("apple", "banana", "avocado", "apricot");
        char symbol = 'a';
        List<String> filtred = ListOperations.filterSortByLength(length, symbol);
        filtred.forEach(System.out::println);

        List<Integer> listAll = Arrays.asList(1, 2, 3, 4);
        System.out.println(listAll);
        List<String> listBinary = ListOperations.convertToBinary(listAll);
        listBinary.forEach(System.out::println);

        List<String> string = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphab = "abcdefghijklmnopqrstuvwxyz";
        List<String> filter = ListOperations.filterAndSortByLength(string, alphab);
        filter.forEach(System.out::println);









    }
}
