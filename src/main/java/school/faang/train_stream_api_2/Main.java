package school.faang.train_stream_api_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.train_stream_api_2.ListOperations.getCapitalsSortedByCountry;
import static school.faang.train_stream_api_2.ListOperations.uniqueCouples;

public class Main {
    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 7;

        Set<Set<Integer>> pairs = uniqueCouples(numbers, target);
        System.out.println(pairs);

        Map<String, String> countries = new HashMap<>();
        countries.put("Germany", "Berlin");
        countries.put("France", "Paris");
        countries.put("Italy", "Rome");
        countries.put("Spain", "Madrid");

        List<String> capitals = getCapitalsSortedByCountry(countries);
        System.out.println(capitals);


        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        ListOperations.filteringAndSortingLines(strings, "");
        System.out.println(strings);


    }
}
