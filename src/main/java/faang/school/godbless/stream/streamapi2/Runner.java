package faang.school.godbless.stream.streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        //findPairsWithSumEqualsTargetSum
        List<Integer> numbers = Arrays.asList(1, 9, 5, 3, 6, 4, 5, 5);
        int targetSum = 10;
        System.out.printf("Target sum: %d%nPairs: %s%n", targetSum, ExtendedStreamUtilOperations.findPairsWithSumEqualsTargetSum(numbers, targetSum));

        //sortCountriesAndReturnCapitals
        Map<String, String> countryToCapital = new HashMap<>();
        countryToCapital.put("Japan", "Tokyo");
        countryToCapital.put("Germany", "Berlin");
        countryToCapital.put("Russia", "Moscow");
        countryToCapital.put("China", "Beijing");
        System.out.printf("Capitals sorted by country name: %s%n", ExtendedStreamUtilOperations.sortCountriesAndReturnCapitals(countryToCapital));

        //filterAndSortStringsWhichStartWithFirstLetter
        List<String> strings = Arrays.asList("apricot", "banana", "peer", "apple", "grape");
        char firstLetter = 'a';
        System.out.printf("Strings starting with '%c' sorted by length: %s%n", firstLetter, ExtendedStreamUtilOperations.filterAndSortStringsWhichStartWithFirstLetter(strings, firstLetter));

        //findPeopleWithCommonFriends
        Map<String, List<String>> personToFriends = new HashMap<>();
        personToFriends.put("Eva", Arrays.asList("Mary", "Petr"));
        personToFriends.put("Mary", Arrays.asList("Eva", "Boris", "Petr"));
        personToFriends.put("Petr", Arrays.asList("Eva", "Mary"));
        personToFriends.put("Boris", Arrays.asList("Mary"));
        System.out.printf("People with common friends: %s%n", ExtendedStreamUtilOperations.findPeopleWithCommonFriends(personToFriends));

        //averageSalaryByDepartment
        List<Employee> employees = Arrays.asList(
                new Employee("Eva", "Development", 1000.00),
                new Employee("Mary", "HR", 1500.00),
                new Employee("Petr", "Development", 800.00),
                new Employee("Boris", "HR", 1200.00),
                new Employee("Noam", "Marketing", 1300.00)
        );
        System.out.printf("Average salary by department: %s%n", ExtendedStreamUtilOperations.averageSalaryByDepartment(employees));

        //filterStringsByAlphabet
        List<String> stringsForAlphabetFilter = Arrays.asList("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.printf("Strings containing only letters from given alphabet sorted by length: %s%n", ExtendedStreamUtilOperations.filterStringsByAlphabet(stringsForAlphabetFilter, alphabet));

        //convertNumbersToBinaryStrings
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        System.out.printf("Binary representation of numbers: %s%n", ExtendedStreamUtilOperations.convertNumbersToBinaryStrings(numberList));

        //findPalindromesInRange
        int startNumber = 100;
        int finishNumber = 125;
        System.out.printf("Palindromes in range from %d to %d: %s%n", startNumber, finishNumber, ExtendedStreamUtilOperations.findPalindromesInRange(startNumber, finishNumber));
    }
}
