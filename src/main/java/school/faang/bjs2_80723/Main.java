package school.faang.bjs2_80723;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> countries = Map.of(
                "England", "London",
                "Germany", "Berlin",
                "France", "Paris");
        List<String> names = List.of("Madison", "John", "James", "Michael", "Mary");
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 802735);
        List<String> words = List.of("aaaaaaaaaaaaaaaaa", "holygodmolydamn", "holymoly", "goddamn", "damn");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("pairs of numbers in list: " + ListOfOperations.findPairs(numbers, 6));
        System.out.println("sorted capitals: " + ListOfOperations.sortCapitals(countries));
        System.out.println("names start with 'M': " + ListOfOperations.filterAndSort(names, 'M'));
        System.out.println("convert list of numbers to Binary: " + ListOfOperations.convertTo(nums));
        System.out.println("sorted list of words by length & alphabet: " +
                ListOfOperations.filterAndSortByAlphabet(words, alphabet));
    }
}
