package lets_practice_streamapi_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Set<Set<Integer>> resultFindUniquePairs = StreamApiProcessor.findUniquePairs(numbers, 7);
        System.out.println("Sum: " + resultFindUniquePairs);

        Map<String, String> words = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");

        List<String> resultSortByCapital = StreamApiProcessor.sortByCapital(words);
        System.out.println("Sorted by Capital: " + resultSortByCapital);

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        List<String> resultSortWordsByLengthAndStartWithLetter = StreamApiProcessor
                .sortWordsByLengthAndStartWithLetter(fruits, 'a');
        System.out.println("Sorted by Length and Start with letter: " + resultSortWordsByLengthAndStartWithLetter);

        List<String> numbersToBinary = StreamApiProcessor.convertNumbersToBinary(List.of(1, 2, 3, 4));
        System.out.println("Binary representation: " + numbersToBinary);

        List<String> wordsByAlphabet = StreamApiProcessor
                .filterWordsByAlphabetAndSort(List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz");
        System.out.println("Sorted by alphabet: " + wordsByAlphabet);
    }
}
