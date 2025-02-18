package school.faang.sprint2.streamapi.task2.bjs2_58101;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<String, String> CAPITALS = Map.ofEntries(
            Map.entry("Russia", "Moscow"),
            Map.entry("USA", "Washington"),
            Map.entry("Germany", "Berlin"),
            Map.entry("Kazakhstan", "Astana")
    );
    private static final Set<Integer> INTEGER_SET = Set.of(2, 6, 7, 5, -4, 0, 10, 3, 1, 13, 12);
    private static final List<String> STRING_LIST = List.of("apple", "banana", "avocado", "plump", "apricot", "pear");
    private static final List<Integer> INTEGERS_LIST = List.of(2, 6, 7, 5, -4, 0, 10, 3, 1, 13, 12);
    private static final List<String> words = List.of("apple", "banana", "cherry", "123", "fig!");
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {
        System.out.println(StreamApi.findNumberPairs(INTEGER_SET, 8));
        System.out.println(StreamApi.sortCountryCapitalsList(CAPITALS));
        System.out.println(StreamApi.sortStringListByLengthStartsWithSymbol(STRING_LIST, 'a'));
        System.out.println(StreamApi.convertIntegerToBinaryNumberList(INTEGERS_LIST));
        System.out.println(StreamApi.filterWordsConsistOfAlphabetLettersAndSortByLength(words, alphabet));
    }
}
