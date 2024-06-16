package faang.school.godbless.streamapi2;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class StreamApi2 {
    public static List<List<Integer>> findPairs(List<Integer> nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<List<Integer>> pairs = new HashSet<>();
        nums.forEach(num -> {
            int complement = target - num;
            if (seen.contains(complement)) {
                List<Integer> pair = asList(Math.min(num, complement), Math.max(num, complement));
                pairs.add(pair);
            }
            seen.add(num);
        });
        return new ArrayList<>(pairs);
    }

    public static List<String> sorted(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> format("%s %s", entry.getKey(), entry.getValue()))
                .toList();
    }

    public static List<String> filterStringsByGivenWord(List<String> stringList, char word) {
        return stringList.stream()
                .filter(string -> string.startsWith(valueOf(word)))
                .sorted(comparingInt(String::length))
                .toList();
    }


    public static Set<String> findNames(Map<String, List<String>> friendships) {
        Set<String> result = new HashSet<>();

        for (String person : friendships.keySet()) {
            List<String> friends = friendships.get(person);
            Set<String> friendSet = new HashSet<>(friends);
            for (String friend : friends) {
                List<String> friendsOfFriend = friendships.get(friend);

                for (String mutualFriend : friendsOfFriend) {
                    if (!mutualFriend.equals(person) && !friendSet.contains(mutualFriend)) {
                        String pair = createOrderedPair(person, mutualFriend);
                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }

    private static String createOrderedPair(String person1, String person2) {
        if (person1.compareTo(person2) < 0) {
            return person1 + " - " + person2;
        } else {
            return person2 + " - " + person1;
        }
    }

    public static Set<String> findNonFriendsWithCommonFriends(Map<String, List<String>> friendsMap) {
        Set<String> allPeople = new HashSet<>(friendsMap.keySet());

        return allPeople.stream()
                .flatMap(person1 -> allPeople.stream()
                        .filter(person2 -> !person1.equals(person2))
                        .filter(person2 -> !friendsMap.get(person1).contains(person2))
                        .map(person2 -> new AbstractMap.SimpleEntry<>(person1, person2)))
                .filter(entry -> {
                    String person1 = entry.getKey();
                    String person2 = entry.getValue();

                    Set<String> commonFriends = friendsMap.get(person1).stream()
                            .filter(friendsMap.get(person2)::contains)
                            .collect(toSet());
                    return !commonFriends.isEmpty();
                })
                .map(entry -> createOrderedPair(entry.getKey(), entry.getValue()))
                .collect(toSet());
    }

    public static Map<String, Double> averageSalaryForEachDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(groupingBy(Employee::department, averagingDouble(Employee::salary)));

    }

    public static List<String> sortByLetters(List<String> stringList, char[] arr) {
        return stringList.stream()
                .filter(string -> containsOnlyAlphabet(string, arr))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static boolean containsOnlyAlphabet(String s, char[] alphabet) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c) || !containsChar(alphabet, Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsChar(char[] array, char c) {
        for (char ch : array) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    public static List<String> integerToBinaryString(List<Integer> integerList) {
        return integerList.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> palindromeDigits(List<Integer> integersList, Integer beginWith, Integer endWith) {
        return integersList.subList(beginWith, endWith)
                .stream()
                .filter(StreamApi2::isPalindrome)
                .toList();
    }

    private static boolean isPalindrome(int number) {
        var stringDigit = valueOf(number);
        String reverseStringDigit = new StringBuilder(stringDigit).reverse().toString();

        return stringDigit.equals(reverseStringDigit);
    }

    public static List<String> findPalindromesInString(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i, input.length() - 1)
                        .mapToObj(j -> input.substring(i, j + 1)))
                .filter(StreamApi2::isPalindrome1)
                .toList();
    }

    private static boolean isPalindrome1(String s) {
        return s.contentEquals(new StringBuilder(s).reverse());
    }
}
