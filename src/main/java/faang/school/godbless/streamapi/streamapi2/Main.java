package faang.school.godbless.streamapi.streamapi2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //1
        List<Integer> integers = List.of(1, 9, 3, 6, 4, 5, 5);
        int targetSum = 10;
        System.out.println(Util.findUniqueIntPairs(integers, targetSum));

        //2
        Map<String, String> countryNameToCapitalName = Map.of(
                "Russia", "Moscow",
                "Sweden", "Stockholm",
                "Poland", "Warsaw");
        System.out.println(Util.sortByKeyAndGetValuesList(countryNameToCapitalName));

        //3
        List<String> strings = List.of("c", "C", "char", "java", "cxx");
        System.out.println(Util.filterByStartCharAndSortByLength(strings, 'c'));

    }
}
