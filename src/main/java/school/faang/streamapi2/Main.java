package school.faang.streamapi2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> stringList = List.of("apple", "banana", "avocado", "apricot", "россия", "африка");

        Map<String, String> country = Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        ListOperations listOperations = new ListOperations();

        System.out.println(listOperations.getPairsOfNumbers(numbers, 7));
        System.out.println(listOperations.sortedCountryByLiteral(country));
        System.out.println(listOperations.sortedListByLiteral(stringList, 'a'));
        System.out.println(listOperations.convertToBinary(numbers));
        System.out.println(listOperations.filteringByAlphabet(stringList, alphabet));
    }
}
