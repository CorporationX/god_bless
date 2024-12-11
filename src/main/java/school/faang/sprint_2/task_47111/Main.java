package school.faang.sprint_2.task_47111;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("expected: [(1, 6), (2, 5), (3, 4)]");
        System.out.println(StreamOperations.findPairsWithSumEqualDestinationNum(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        7));

        HashMap<String, String> countriesMap = new HashMap<>();
        countriesMap.put("Russia", "Moscow");
        countriesMap.put("USA", "Washington");
        countriesMap.put("Germany", "Berlin");
        System.out.println("expected: [Berlin, Moscow, Washington]");
        System.out.println(StreamOperations.sortAndGetCountriesCapitals(countriesMap));

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println("expected: [apple, apricot, avocado]");
        System.out.println(StreamOperations.filterAndSortStings(strings, 'a'));

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println("expected: [1, 10, 11, 100]");
        System.out.println(StreamOperations.decimalToBinaryString(integers));

        List<String> strings1 = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println("expected: [fig, date, apple, grape, banana, cherry]");
        System.out.println(
                StreamOperations.filterStringByCustomAlphabetAndSortByLength(
                        strings1,
                        "abcdefghijklmnopqrstuvwxyz"));
    }
}
