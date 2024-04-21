package faang.school.godbless.stream.streamapi2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExtendedStreamUtilOperations {

    public static List<List<Integer>> findPairsWithSumEqualsTargetSum(List<Integer> numbers, int targetSum) {
        Map<Integer, Long> numberToCountMap = numbers.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        List<List<Integer>> result = new ArrayList<>();
        Set<Pair> usedPairs = new HashSet<>();

        numbers.stream()
                .distinct()
                .forEach(number -> {
                    int complement = targetSum - number;
                    if (numberToCountMap.containsKey(complement)) {
                        long countNumber = numberToCountMap.get(number);
                        long countComplement = numberToCountMap.get(complement);
                        if ((number == complement && countNumber > 1) || (number != complement && countComplement > 0)) {
                            Pair pair = new Pair(number, complement);
                            if (usedPairs.add(pair)) {
                                result.add(Arrays.asList(pair.first(), pair.second()));
                            }
                        }
                    }
                });
        return result;
    }

    public static List<String> sortCountriesAndReturnCapitals(Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStringsWhichStartWithFirstLetter(List<String> strings, char firstLetter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(firstLetter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<List<String>> findPeopleWithCommonFriends(Map<String, List<String>> personToFriends) {
        List<List<String>> result = new ArrayList<>();

        personToFriends.keySet().forEach(person ->
                personToFriends.keySet().stream()
                        .filter(otherPerson ->
                                !person.equals(otherPerson)
                                        && !personToFriends.get(person).contains(otherPerson))
                        .filter(otherPerson -> !personToFriends.get(otherPerson).contains(person))
                        .forEach(otherPerson -> {
                            Set<String> commonFriends = findCommonFriends(person, otherPerson, personToFriends);
                            if (!commonFriends.isEmpty()) {
                                List<String> pair = Stream.of(person, otherPerson).sorted().collect(Collectors.toList());
                                if (!result.contains(pair)) {
                                    result.add(pair);
                                }
                            }
                        })
        );
        return result;
    }

    private static Set<String> findCommonFriends(String person, String otherPerson, Map<String, List<String>> personToFriends) {
        Set<String> commonFriends = new HashSet<>(personToFriends.get(person));
        commonFriends.retainAll(personToFriends.get(otherPerson));
        return commonFriends;
    }

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterStringsByAlphabet(List<String> strings, char[] alphabet) {
        Set<Character> validChars = IntStream.range(0, alphabet.length)
                .mapToObj(i -> alphabet[i])
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars().allMatch(c -> validChars.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertNumbersToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPalindromesInRange(int startNumber, int finishNumber) {
        return IntStream.rangeClosed(startNumber, finishNumber)
                .filter(i -> {
                    String str = Integer.toString(i);
                    return str.equals(new StringBuilder(str).reverse().toString());
                }).boxed()
                .collect(Collectors.toList());
    }
}