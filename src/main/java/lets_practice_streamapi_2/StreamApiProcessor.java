package lets_practice_streamapi_2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiProcessor {
    /**
     * Find all unique pairs of numbers in the given set that sum up to the given
     * target sum.
     *
     * @param numbers the set of numbers to search through
     * @param sum the target sum
     * @return a set of sets of two numbers each that sum up to the target sum
     */
    public static Set<Set<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        return numbers
                .stream()
                .filter(n -> numbers.contains(sum - n))
                .map(n -> Set.of(n, sum - n))
                .collect(Collectors.toSet());
    }

    /**
     * Sorts the given map of words by their capital, and returns a list of the
     * capitals in sorted order.
     *
     * @param words the map of words and their capitals
     * @return a list of the capitals in the given map, sorted by capital
     */
    public static List<String> sortByCapital(Map<String, String> words) {
        return words
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .toList();
    }

    /**
     * Sorts the given list of words by length in descending order, and
     * filters out all words that don't start with the given letter.
     *
     * @param words the list of words to sort
     * @param letter the first letter of the words to filter
     * @return the filtered and sorted list of words
     */
    public static List<String> sortWordsByLengthAndStartWithLetter(List<String> words, char letter) {
        return words
                .stream()
                .filter(word -> word.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    /**
     * Converts each number in the given list to its binary string representation
     * and returns the list of binary strings.
     *
     * @param numbers the list of numbers to convert
     * @return a list of binary strings, where each string is the binary
     * representation of the corresponding number in the input list
     */
    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers
                .stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    /**
     * Filters the given list of words by only keeping words that contain
     * at least one character from the given alphabet, and then sorts the
     * resulting list lexicographically.
     *
     * @param words the list of words to filter and sort
     * @param alphabet the alphabet to filter by
     * @return the filtered and sorted list of words
     */
    public static List<String> filterWordsByAlphabetAndSort(List<String> words, String alphabet) {
        return words
                .stream()
                .filter(word -> word.toLowerCase().chars().anyMatch(ch -> alphabet.indexOf(ch) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
