package school.faang.stream.api.third;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> personToFriends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        System.out.println(findPairsWithCommonFriends(personToFriends));

        List<Employee> employees = Arrays.asList(
                new Employee("Коля", 321, "Отдел разработки"),
                new Employee("Дима", 300, "Отдел разработки"),
                new Employee("Настя", 50, "Отдел дизайна"),
                new Employee("Костя", 56, "Отдел дизайна"),
                new Employee("Саша", 121, "Отдел SMM"),
                new Employee("Юля", 150, "Отдел SMM")
        );
        System.out.println(countAvgSalaryByDepartment(employees));
        System.out.println(findPalindromesBetween(100, 200));
        System.out.println(findAllPalindromeSubstrings("abac"));
        System.out.println(findPerfectNumbers(1, 1000));
    }

    public static List<Pair> findPairsWithCommonFriends(Map<String, List<String>> personToFriends) {
        return personToFriends.entrySet().stream()
                .flatMap(entry -> {
                    String currentPerson = entry.getKey();
                    List<String> friends = entry.getValue();

                    return friends.stream()
                            .flatMap(friend -> personToFriends.get(friend).stream()
                                    .filter(mutualFriendCandidate ->
                                            !mutualFriendCandidate.equals(currentPerson) &&
                                                    !friends.contains(mutualFriendCandidate))
                                    .map(mutualFriendCandidate -> new Pair(currentPerson, mutualFriendCandidate)));
                })
                .distinct()
                .toList();
    }

    public static Map<String, Double> countAvgSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ));
    }

    public static List<Integer> findPalindromesBetween(int leftBound, int rightBound) {
        return Stream.iterate(leftBound, num -> num <= rightBound, num -> num + 1)
                .filter(Main::isPalindrome)
                .toList();
    }

    private static boolean isPalindrome(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        for (int i = 0; i < n / 2; i++) {
            if (numStr.charAt(i) != numStr.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static Set<String> findAllPalindromeSubstrings(String s) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i, result);
            expandAroundCenter(s, i, i + 1, result);
        }
        return result;
    }

    private static void expandAroundCenter(String s, int left, int right, Set<String> result) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result.add(s.substring(left, right + 1));
            left--;
            right++;
        }
    }

    public static List<Integer> findPerfectNumbers(int leftBound, int rightBound) {
        return Stream.iterate(leftBound, num -> num <= rightBound, num -> num + 1)
                .filter(Main::isPerfectNumber)
                .toList();
    }

    private static boolean isPerfectNumber(int num) {
        int sumOfDivisors = Stream.iterate(1, i -> i <= (int) Math.sqrt(num), i -> i + 1)
                .filter(i -> num % i == 0)
                .flatMap(i -> Stream.of(i, num / i))
                .distinct()
                .reduce(0, Integer::sum);
        return sumOfDivisors - num == num;
    }
}
