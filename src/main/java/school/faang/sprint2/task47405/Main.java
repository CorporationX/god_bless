package school.faang.sprint2.task47405;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(11, 12, 13, 14, 1, 2, 3, 4, 5, 8, 4, 5, 6, 7, 8, 9);

        Set<List<Integer>> pairs = StreamFunc.getUniquePairs(numbers, 10);
        System.out.println(pairs);

        Map<String, String> capitals = new HashMap<>();
        capitals.put("Russia", "Moscow");
        capitals.put("USA", "Washington");
        capitals.put("Germany", "Berlin");

        List<String> cities = StreamFunc.getSortedCities(capitals);
        System.out.println(cities);

        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        List<String> sortedStrings = StreamFunc.getSelectedStrings(strings, 'a');
        System.out.println(sortedStrings);

        List<String> binaryNumbers = StreamFunc.numberToBinaryList(numbers);
        System.out.println(binaryNumbers);

        List<String> someStrings = List.of("apple", "banana", "cherry", "date", "fig", "grape", "Orange", "Peach");
        List<String> selectedStrings = StreamFunc.sortStringsByAlphabet(someStrings, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(selectedStrings);

    }
}
