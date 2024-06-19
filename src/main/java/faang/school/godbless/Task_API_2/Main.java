package faang.school.godbless.Task_API_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    static final List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5);
    static final int target = 10;
    static final List<String> strings = Arrays.asList("something", "some", "sad", "new", "now", "sold");

    public static void main(String[] args) {
        //task1
        Set<Solver.Pair> task1 = Solver.findPairs(numbers, target);
        System.out.println(task1);
        //task2
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("England", "London");
        countriesAndCapitals.put("Spain", "Madrid");
        countriesAndCapitals.put("France", "Paris");
        System.out.println(StringService.sortCapitals(countriesAndCapitals));
        //task3
        System.out.println(StringService.stringFilter(strings, 's'));
    }

}
