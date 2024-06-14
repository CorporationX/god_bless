package faang.school.godbless.streamapi2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SomeMethods {
    public static Set<Set<Integer>> findAllPairs(List<Integer> nums, int targetSum) {
        return IntStream.range(0, nums.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.size())
                        .filter(j -> nums.get(i) + nums.get(j) == targetSum)
                        .mapToObj(j -> Set.of(nums.get(i), nums.get(j)))
                )
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterListByChar(List<String> stringList, char ch) {
        String startChar = String.valueOf(ch);
        return stringList.stream()
                .filter(str -> str.startsWith(startChar))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<List<String>> findPeople(Map<String, List<String>> map){
        return map.keySet().stream()
                .flatMap(person1 -> map.keySet().stream()
                        .filter(person2 -> !person1.equals(person2) && !map.get(person1).contains(person2))
                        .map(person2 -> {
                            List<String> pair = Arrays.asList(person1, person2);
                            Collections.sort(pair);
                            return pair;
                        })
                )
                .filter(pair -> haveCommonFriends(map, pair.get(0), pair.get(1)))
                .distinct()
                .toList();
    }

    public static boolean haveCommonFriends(Map<String, List<String>> map, String person1, String person2) {
        Set<String> friendsOfPerson1 = new HashSet<>(map.get(person1));
        Set<String> friendsOfPerson2 = new HashSet<>(map.get(person2));
        friendsOfPerson1.retainAll(friendsOfPerson2);
        return !friendsOfPerson1.isEmpty();
    }

    public static Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<String> filterByAlphabet(List<String> stringList, Set<Character> chars) {
        return stringList.stream()
                .filter(str -> str.chars().allMatch(c -> chars.contains((char) c)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> findAllPalindrome(int start, int end) {
        return IntStream.range(start, end)
                .filter(SomeMethods::isPalindrome)
                .boxed()
                .toList();
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }
}

