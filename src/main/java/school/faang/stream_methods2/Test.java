package school.faang.stream_methods2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        System.out.println("findPairs: " + StreamMethods.findPairs(numbers, 5));

        Map<String, String> countries = Map.of(
                "Germany", "Berlin",
                "France", "Paris",
                "Italy", "Rome"
        );
        System.out.println("sortCountries: " + StreamMethods.sortCountries(countries));

        List<String> words = List.of("apple", "banana", "avocado", "cherry", "apricot");
        System.out.println("sortStringsByChar: " +
                StreamMethods.sortStringsByChar(words, 'a'));

        List<Integer> nums = List.of(1, 3, 5);
        System.out.println("listToBinary: " + StreamMethods.listToBinary(nums));

        List<String> strings = List.of("abc", "cab", "def", "a", "bad");
        System.out.println("filterStringsAlfa: " +
                StreamMethods.filterStringsAlphabet(strings, "abc"));
    }
}
