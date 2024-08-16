package faang.school.godbless.sprint2.streamAPI.BJS2_22432;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Tasks.printPairsWithSum(List.of(1,9,4,6,8,2), 10);

        /*Map<String, String> countriesAndCapitals = Map.of(
                "France", "Paris",
                "Germany", "Berlin",
                "Italy", "Rome",
                "Spain", "Madrid"
        );
        List<String> capitals = Tasks.getCapitalsSortedByCountry(countriesAndCapitals);
        System.out.println("Capitals sorted by country: " + capitals);*/

        List<String> strings = List.of("apple", "banana", "cherry", "date", "apricot", "blueberry");
        char startingLetter = 'a';
        List<String> filteredAndSorted = Tasks.filterAndSortStringsByLength(strings, startingLetter);
        System.out.println("Filtered and sorted strings: " + filteredAndSorted);
    }
}
