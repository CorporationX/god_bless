package lets_practice_streamapi_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    /**
     * Given a list of numbers, returns the sum of all the even numbers
     * in the list.
     *
     * @param numbers the list of numbers to sum
     * @return the sum of all the even numbers in the list
     */
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    /**
     * Given a list of numbers, returns the maximum number in the list.
     *
     * @param numbers the list of numbers to find the maximum of
     * @return the maximum number in the list
     */
    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Comparator.comparingInt(a -> a)).get();
    }

    /**
     * Given a list of numbers, returns the average of all the numbers
     * in the list.
     *
     * @param numbers the list of numbers to average
     * @return the average of all the numbers in the list
     */
    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    /**
     * Given a list of strings, returns the number of strings that start
     * with the given letter.
     *
     * @param strings the list of strings to count
     * @param letterStart the letter to search for
     * @return the number of strings that start with the given letter
     */
    public static int countStringsStartingWith(List<String> strings, char letterStart) {
        return (int) strings.stream().filter(str -> str.startsWith(String.valueOf(letterStart))).count();
    }

    /**
     * Given a list of strings, returns a new list with only the strings
     * that contain the given substring.
     *
     * @param strings the list of strings to filter
     * @param substring the substring to search for
     * @return a new list with only the strings that contain the substring
     */
    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(str -> str.contains(substring)).toList();
    }

    /**
     * Returns a new list with the same strings as the original list, but
     * sorted by their length.
     *
     * @param strings the list of strings to sort
     * @return a new list with the same strings as the original, but sorted by length
     */
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    /**
     * Returns true if all numbers in the list satisfy the given predicate.
     *
     * @param numbers the list of numbers to check
     * @param filter the predicate to check
     * @return true if all numbers in the list satisfy the predicate
     */
    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream().allMatch(filter);
    }

    /**
     * Given a list of numbers, returns the minimum number in the list
     * that is greater than the given number.
     *
     * @param numbers the list of numbers to search
     * @param biggerNumber the number to compare against
     * @return the minimum number in the list that is greater than the given number
     */
    public static int findMinGreaterThan(List<Integer> numbers, int biggerNumber) {
        return numbers.stream().sorted().filter(n -> n > biggerNumber).findFirst().get();
    }

    /**
     * Returns a new list where each element is the length of the corresponding
     * element in the given list of strings.
     *
     * @param strings the list of strings to convert
     * @return a new list with the same length as the given list, but with each
     * element being the length of the corresponding string
     */
    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
