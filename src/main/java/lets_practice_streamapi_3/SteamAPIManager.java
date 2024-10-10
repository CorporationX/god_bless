package lets_practice_streamapi_3;

import java.util.ArrayList;
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
        int reversed = 0, original = number;

        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }

        return original == reversed;
    }
    
    /**
     * Finds all the palindrome substrings of the given input string.
     * <p>
     * A palindrome is a number or a text phrase that reads the same backwards as forwards.
     * For example, the string "abcddcba" is a palindrome.
     * <p>
     * This method returns a list of all the palindrome substrings of the given input string.
     * <p>
     * The algorithm works by iterating over the string and expanding the palindrome
     * from each character outwards. It takes advantage of the fact that a palindrome
     * must have an even length, so it only needs to check substrings of even length.
     *
     * @param input the input string to find palindrome substrings in
     * @return a list of all the palindrome substrings of the given input string
     */
    public static List<String> findPalindromeSubstrings(String input) {
        List<String> palindromes = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            expandAndCollectPalindromes(input, i, i, palindromes);
            expandAndCollectPalindromes(input, i, i + 1, palindromes);
        }

        return palindromes;
    }

    /**
     * Expands around the given center and collects all the palindromic substrings
     * of the given string.
     * <p>
     * The given center is the center of a potential palindrome. The method starts
     * by checking if the characters to the left and right of the center are equal.
     * If they are, the method adds the substring from the left to the right (inclusive)
     * to the list of palindromes if it is not already there. Then the method moves
     * one character to the left and one character to the right and repeats the process
     * until the characters to the left and right of the center are different.
     * <p>
     * The method assumes that the input string does not contain any null characters.
     *
     * @param input the string to find palindromic substrings in
     * @param left the starting index of the left side of the potential palindrome
     * @param right the starting index of the right side of the potential palindrome
     * @param palindromes the list of palindromes to add to
     */
    private static void expandAndCollectPalindromes(String input, int left, int right, List<String> palindromes) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            String palindrome = input.substring(left, right + 1);
            if (!palindromes.contains(palindrome)) {
                palindromes.add(palindrome);
            }
            left--;
            right++;
        }
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
