package faang.school.godbless.BJS222457;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5);
        int target = 10;
        StreamApiTasks.findUniqueSum(numbers, target);
        System.out.println();

        Map<String, String> countryAndCapital = new HashMap<>();
        countryAndCapital.put("Russia", "Moscow");
        countryAndCapital.put("United States", "Washington");
        countryAndCapital.put("Germany", "Berlin");
        countryAndCapital.put("France", "Paris");
        System.out.println(StreamApiTasks.sortAlphabeticallyAndDisplay(countryAndCapital));
        System.out.println();

        List<String> strings = List.of("hello", "good", "son", "program", "helping", "hi");
        StreamApiTasks.sortListByCharAndLength(strings, "h");
        System.out.println();


    }
}
