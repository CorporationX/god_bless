package faang.school.godbless.stream.collectionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionHandler {


    public static List<List<Integer>> findPairsBySum(List<Integer> numbers, int sum) {

        List<List<Integer>> uniquePairs = new ArrayList<>();

        numbers.forEach(currentNumber -> numbers.stream()
                .filter(number -> sum - currentNumber == number)
                .filter(number -> uniquePairs.stream().noneMatch(integers -> integers.contains(currentNumber)))
                .forEach(integer -> uniquePairs.add(Arrays.asList(currentNumber, integer))));
        return uniquePairs;
    }

    public static List<String> sortCountriesByCapital(Map<String, String> countries) {

        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterByLetter(List<String> strings, char letter) {
        return strings.stream()
                .map(String::toLowerCase)
                .filter(str -> str.startsWith(String.valueOf(letter).toLowerCase()))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<List<String>> findCommonFriends(Map<String, List<String>> friends) {

        List<List<String>> pairs = new ArrayList<>();
        List<List<String>> sortedPairs = new ArrayList<>();
        friends.keySet().forEach(currentPerson ->
                friends.keySet().stream()
                        .filter(friend -> !friend.equals(currentPerson))
                        .filter(friend -> !friends.get(currentPerson).contains(friend))
                        .filter(friend -> new HashSet<>(friends.get(friend)).containsAll(friends.get(currentPerson)))
                        .forEach(otherPerson -> pairs.add(Arrays.asList(currentPerson, otherPerson)))
        );

        pairs.forEach(strings -> {
            strings.sort(Comparator.naturalOrder());
            sortedPairs.add(strings);
        });

        return sortedPairs.stream().distinct().toList();
    }

    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabet(List<String> strings, String[] alphabet) {
        Set<Character> alphabetSet = Arrays.stream(alphabet)
                .flatMapToInt(CharSequence::chars)
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars().allMatch(ch -> alphabetSet.contains((char)ch)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<Integer> findPalindromes(int start, int end) {

        return IntStream.rangeClosed(start, end)
                .filter(number -> isPalindrome(Integer.toString(number)))
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(String numberString) {
        String numberWithoutMinus = numberString.replace("-", "");
        int i = 0;
        int j = numberWithoutMinus.length() - 1;
        while (i < j) {
            if (numberWithoutMinus.charAt(i) != numberWithoutMinus.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}