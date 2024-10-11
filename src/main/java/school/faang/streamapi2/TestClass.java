package school.faang.streamapi2;

import java.util.List;
import java.util.Map;

public class TestClass {
    public static void main(String[] args) {
        List<Integer> listInt = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(StreamApiTester.findPairs(listInt, 7));

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        System.out.println("Capitals:" + StreamApiTester.sortCountries(countries));

        List<String> stringList = List.of("apple", "banana", "avocado", "apricot");
        System.out.println("Sorted strings:" + StreamApiTester.filterByChar(stringList, 'a'));

        System.out.println("To binary:" + StreamApiTester.toBinary(listInt));

        List<String> stringOtherList = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Filter by alphabet:" + StreamApiTester.filterByAlphabet(stringOtherList, alphabet));
    }
}
