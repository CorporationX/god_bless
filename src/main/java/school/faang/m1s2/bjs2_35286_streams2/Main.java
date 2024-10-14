package school.faang.m1s2.bjs2_35286_streams2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        StreamOperations.findUniquePairs(numbers, 7).forEach(System.out::println);

        Map<String, String> countriesToCapital = Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");

        System.out.println(StreamOperations.showCapitals(countriesToCapital));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        System.out.println(StreamOperations.sortByFilterLength(fruits, 'a'));

        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println(StreamOperations.convertIntToBinary(nums));

        List<String> fruits2 = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        StreamOperations.filterSortByAlphabet(fruits2, alphabet).forEach(System.out::println);
    }
}
