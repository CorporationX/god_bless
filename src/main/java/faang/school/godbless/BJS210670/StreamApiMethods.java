package faang.school.godbless.BJS210670;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiMethods {
    public static List<String> convertToBinary(List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).toList();

    }

    public static Map<String, Double> findAverageSalary(List<Employee> employeeList) {
        Map<String, Double> result = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartament, Collectors.averagingDouble(Employee::getSalary))
        );
        return result;
    }

    public static List<List<String>> findCommonFriends(Map<String, List<String>> friendsMap) {
        Set<List<String>> pairsSet = new HashSet<>();

        friendsMap.keySet().stream()
                .flatMap(person ->
                        friendsMap.keySet().stream()
                                .filter(otherPerson -> !otherPerson.equals(person))
                                .filter(otherPerson -> !friendsMap.get(person).contains(otherPerson))
                                .filter(otherPerson -> hasCommonFriends(person, otherPerson, friendsMap))
                                .map(otherPerson -> Arrays.asList(person, otherPerson))
                )
                .forEach(pair -> {
                    List<String> sortedPair = pair.stream().sorted().collect(Collectors.toList());
                    pairsSet.add(sortedPair);
                });

        return new ArrayList<>(pairsSet);
    }

    private static boolean hasCommonFriends(String friend, String otherFriend, Map<String, List<String>> friendsMap) {
        Set<String> setFriend = new HashSet<>(friendsMap.get(friend));
        Set<String> setOtherFriend = new HashSet<>(friendsMap.get(otherFriend));

        setFriend.retainAll(setOtherFriend);
        return !setFriend.isEmpty();
    }

    public static List<Integer> allPalindromes(int lowerBand, int upperBand) {

        return IntStream.rangeClosed(lowerBand, upperBand)
                .filter(StreamApiMethods::isPalindromeNumber)
                .boxed()
                .toList();
    }

    private static boolean isPalindromeNumber(int value) {
        if (value < 0) {
            return false;
        }
        String number = Integer.toString(value);
        String reverseNumber = new StringBuilder(number).reverse().toString();
        return number.equals(reverseNumber);
    }

    public static Map<String, String> sortCountries(Map<String, String> countries) {
        Map<String, String> resultMap = countries.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));

        List<String> capitals = resultMap.values().stream().toList();
        capitals.forEach(System.out::println);
        return resultMap;
    }

    public static Set<Character> convertToChar(String s) {
        return s.chars().mapToObj(c -> Character.toLowerCase((char) c)).collect(Collectors.toSet());
    }

    public static List<String> sortLines(List<String> lines, Set<Character> alphabet) {
        List<String> result = lines.stream()
                .filter(line -> hasLetterFromAlphabet(line, alphabet))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        return result;
    }

    private static boolean hasLetterFromAlphabet(String line, Set<Character> alphabet) {
        for (char c : line.toCharArray()) {
            if (!alphabet.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }

    public static List<String> startsWithCharacter(List<String> lines, char letter) {
        return lines.stream()
                .filter((line) -> line.toLowerCase().startsWith(String.valueOf(letter)))
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> targetSum(List<Integer> nums, int target) {
        List<List<Integer>> result = nums.stream().flatMap(firstNum -> nums.stream()
                        .filter(secondNums -> firstNum != secondNums && firstNum + secondNums == target)
                        .map(secondNum -> List.of(firstNum, secondNum)))
                .distinct()
                .collect(Collectors.toList());
        return result;
    }
}
