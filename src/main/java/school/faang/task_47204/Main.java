package school.faang.task_47204;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        Set<List<Integer>> list1 = WorkingWithStream.uniquePairsOfNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        System.out.println(list1);

        System.out.println("---------------------------------------------");

        Map<String, String> map = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        List<String> list2 = WorkingWithStream.sortingCity(map);
        System.out.println(list2);

        System.out.println("---------------------------------------------");

        List<String> list3 = WorkingWithStream.filteringAndSortingString(
                List.of("apple", "banana", "avocado", "apricot"), 'a');
        System.out.println(list3);

        System.out.println("---------------------------------------------");

        List<String> list4 = WorkingWithStream.conversionBinaryFormat(
                List.of(1, 2, 3, 4));
        System.out.println(list4);

        System.out.println("---------------------------------------------");

        List<String> list5 = WorkingWithStream.filterStringAlphabeticallyAndLength(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz");
        System.out.println(list5);


    }
}
