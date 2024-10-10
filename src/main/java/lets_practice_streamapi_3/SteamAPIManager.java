package lets_practice_streamapi_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SteamAPIManager {
    /**
     * Given a map of person names to lists of their friends, returns a list of pairs of
     * people who are not friends with each other but have at least one common friend.
     *
     * @param friendsMap a map where the keys are person names and the values are lists of
     *                   their friends
     * @return a list of lists of two strings, where each inner list contains two people
     *         who are not friends with each other but have at least one common friend
     */
    public static List<List<String>> findNonFriendPairsWithCommonFriends(Map<String, List<String>> friendsMap) {
        return friendsMap.keySet().stream()
                .flatMap(person -> {
                    List<String> personFriends = friendsMap.get(person);
                    return personFriends.stream()
                            .flatMap(friend -> friendsMap.get(friend).stream()
                                    .filter(potentialMutual -> !person.equals(potentialMutual) && !personFriends.contains(potentialMutual))
                                    .map(potentialMutual -> {
                                        List<String> pair = Arrays.asList(person, potentialMutual);
                                        Collections.sort(pair);
                                        return pair;
                                    })
                            );
                })
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Given a list of employees, returns a map from department name to average salary of
     * the employees in that department.
     *
     * @param employees a list of employees
     * @return a map from department name to average salary
     */
    public static Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    /**
     * Finds all the palindromes between the given start and end values, inclusive.
     *
     * @param start the start of the range
     * @param end the end of the range
     * @return a list of all the palindromes between the given start and end values
     */
    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(SteamAPIManager::isPalindrome)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Checks if the given number is a palindrome.
     * <p>
     * A palindrome is a number or a text phrase that reads the same backwards as forwards.
     * For example, the number 12321 is a palindrome.
     * <p>
     * This method is private and used internally by {@link #findPalindromes(int, int)}.
     *
     * @param number the number to check
     * @return true if the number is a palindrome, false otherwise
     */
    private static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    /**
     * Finds all the palindromic substrings of the given string.
     * <p>
     * A palindromic substring is a substring that reads the same backwards as forwards.
     * For example, the string "madam" has the following palindromic substrings: "madam", "ada", "madam", "ada".
     * <p>
     * The returned list will not contain any duplicate substrings.
     *
     * @param input the string to find palindromic substrings in
     * @return a list of all the palindromic substrings of the given string
     */
    public static List<String> findPalindromeSubstrings(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, input.length() + 1)
                        .mapToObj(j -> input.substring(i, j)))
                .filter(str -> str.contentEquals(new StringBuilder(str).reverse()))
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Finds all the perfect numbers in the given range, inclusive.
     * <p>
     * A perfect number is a positive integer that is equal to the sum of its proper positive divisors,
     * excluding the number itself.
     * <p>
     * The returned list will not contain any duplicate numbers.
     *
     * @param start the start of the range
     * @param end the end of the range
     * @return a list of all the perfect numbers in the given range
     */
    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> {
                    int sumOfDivisors = IntStream.range(1, number)
                            .filter(i -> number % i == 0)
                            .sum();
                    return sumOfDivisors == number;
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
