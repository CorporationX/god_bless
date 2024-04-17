package faang.school.godbless.practice.streamapi2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Practice {
    public static List<int[]> getListOfUniquePairsWhichSumEqualsToCertainNumber(List<Integer> numbers, int sum) {
        Map<Integer, Integer> pair = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        numbers.stream()
                .distinct()
                .forEach(n -> {
                    if (pair.containsKey(n)) {
                        if (pair.get(n) != null) {
                            result.add(new int[]{n, sum - n});
                        }
                    } else if (!pair.containsValue(n)) {
                        pair.put(sum - n, n);
                    }
                });
        return result;
    }

    public static List<String> sortCountriesAndGetListOfCapitals(Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getListOfStringsFilteredBySpecificCharacterAndSortedByLengthAsc(List<String> strings, char character) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> getListOfPeopleWhoAreNotFriendsButHaveCommonFriends(Map<String, List<String>> personToFriendsList) {
        return personToFriendsList.keySet().stream()
                .map(strings -> getListOfPairsWithCommonFriends(strings, personToFriendsList))
                .flatMap(List::stream)
                .peek(Collections::sort)
                .distinct()
                .toList();
    }

    private static List<List<String>> getListOfPairsWithCommonFriends(String person, Map<String, List<String>> personToFriendsList) {
        List<String> friendsListOfPerson = personToFriendsList.get(person);
        return personToFriendsList.entrySet().stream()
                .filter(entry -> {
                    boolean isSame = person.equals(entry.getKey());
                    boolean doesContain = entry.getValue().contains(person);
                    List<String> copyOfFriendsListOfPerson = new ArrayList<>(friendsListOfPerson);
                    copyOfFriendsListOfPerson.retainAll(entry.getValue());
                    return !isSame && !doesContain && !copyOfFriendsListOfPerson.isEmpty();
                })
                .map(entry -> new ArrayList<>(List.of(person, entry.getKey())))
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getDepartmentToAvgSalaryMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ));
    }

    public static List<String> getStringsListFilteredByAlphabetRelating(List<String> strings, String[] symbols) {
        char firstChar = symbols[0].charAt(0);
        char lastChar = symbols[symbols.length - 1].charAt(0);

        return strings.stream()
                .filter(str -> doesBelongToAlphabet(str, firstChar, lastChar))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static boolean doesBelongToAlphabet(String str, char firstChar, char lastChar) {
        for (int i = 0; i < str.length(); i++) {
            char currentCharOfStr = str.charAt(i);
            if (firstChar > currentCharOfStr || lastChar < currentCharOfStr) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getListNumbersInBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }


    public static List<Integer> getPalindromesListOnRange(int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }

        return numbers.stream()
                .filter(Practice::isPalindrome)
                .toList();
    }


    private static boolean isPalindrome(int num) {
        int rev = reverseNum(num, 0);
        return rev == num;
    }

    private static int reverseNum(int n, int rev) {
        if (n < 10) {
            return rev * 10 + n;
        } else {
            int last_digit = n % 10;
            rev = rev * 10 + last_digit;
            return reverseNum(n / 10, rev);
        }
    }
}
