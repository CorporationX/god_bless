package faang.school.godbless.streamApi2;

import java.util.*;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 9, 3, 6, 4, 5);
        Map<String, String> countryCapital = Map.of(
                "Albania", "Tirana",
                "Singapore", "Singapore",
                "China", "Beijing",
                "Bulgaria", "Sofia");
        char startingChar = 'S';

        Map<String, List<String>> userFriends = new HashMap<>();
        userFriends.put("Alice", Arrays.asList("John", "Charlie", "David"));
        userFriends.put("John", Arrays.asList("Alice", "Charlie"));
        userFriends.put("Eve", List.of("David"));
        userFriends.put("David", Arrays.asList("Alice", "Eve"));


        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 3, "Marketing"),
                new Employee("Charlie", 3, "Marketing"),
                new Employee("Eve", 6, "Marketing"),
                new Employee("Bob", 1, "Finance"),
                new Employee("David", 1, "Finance"),
                new Employee("Frank", 4, "Finance")
        );

        List<String> rows = List.of("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        log.info(String.format("1. Sum even number: %s", Utils.getUniquePairsSumEqualGivenNumber(nums, 10)));
        log.info(String.format("2. Capitals: %s", Utils.getCapitalsOfSortedCountries(countryCapital)));
        log.info(String.format("3. Sorted rows stared with %s: %s",
                startingChar, Utils.getAskLengthSortedListStartingWith(countryCapital.values(), startingChar)));
        log.info(String.format("4. Non friends: %s", Utils.getNonFriendsUsers(userFriends)));
        log.info(String.format("5. Departments salary: %s", Utils.getDepartmentAverageSalary(employees)));
        log.info(String.format("6. Alphabetic rows: %s", Utils.getAlphabeticRowsSortedByLength(rows, alphabet)));
        log.info(String.format("7. Binary strings: %s", Utils.convertIntegersToBinaryStrings(nums)));
        log.info(String.format("8. Palindrome numbers: %s", Utils.getPalindromeNumbers(-100, 1000)));
    }
}
