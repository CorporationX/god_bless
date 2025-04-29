package stream.practice.two;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, String> countries = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");

        System.out.println(StreamsUtility.getCountryCapital(countries));
        System.out.println(StreamsUtility.sortStringsBySymbol(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(StreamsUtility.mapToBinary(List.of(2, 3, 5, 1, 7)));
        System.out.println(StreamsUtility.filterStringByAlphabet(
                List.of("apple", "banana", "Cherry", "date", "fig", "grape"), "Abcdefghijklmnopqrstuvwxyz"));
        System.out.println(StreamsUtility.findPairEqualsTarget(Set.of(1, 2, 3, 4, 5, 6), 6));
    }
}
