package streamapi3;

import lombok.experimental.UtilityClass;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Objects;

@UtilityClass
public class StreamOperations3 {

    private static final String ERR_NULL_FRIENDS_MAP = "Friends map must not be null";
    private static final String ERR_NULL_EMPLOYEES_LIST = "Employees list must not be null";
    private static final String ERR_NULL_INPUT_STRING = "Input string must not be null";

    public List<PeoplePair> findPeopleWithCommonFriends(Map<String, List<String>> friendsMap) {
        if (friendsMap == null) {
            throw new IllegalArgumentException(ERR_NULL_FRIENDS_MAP);
        }
        List<String> people = friendsMap.keySet().stream().sorted().toList();
        return IntStream.range(0, people.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, people.size())
                        .mapToObj(j -> {
                            String person1 = people.get(i);
                            String person2 = people.get(j);
                            List<String> friends1 = friendsMap.getOrDefault(person1, List.of());
                            List<String> friends2 = friendsMap.getOrDefault(person2, List.of());
                            boolean areFriends = friends1.contains(person2) || friends2.contains(person1);
                            List<String> commonFriends = friends1.stream()
                                    .filter(friends2::contains)
                                    .toList();
                            if (!areFriends && !commonFriends.isEmpty()) {
                                return new PeoplePair(person1, person2);
                            }
                            return null;
                        }))
                .filter(Objects::nonNull)
                .toList();
    }

    public Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException(ERR_NULL_EMPLOYEES_LIST);
        }
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    public List<Integer> findPalindromicNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(StreamOperations3::isPalindrome)
                .boxed()
                .toList();
    }

    public List<String> findPalindromicSubstrings(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERR_NULL_INPUT_STRING);
        }
        int n = input.length();
        return IntStream.range(0, n)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, n)
                        .mapToObj(j -> input.substring(i, j)))
                .filter(s -> s.length() > 0 && isPalindrome(s))
                .distinct()
                .toList();
    }

    private boolean isPalindrome(int number) {
        String s = Integer.toString(number);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public List<Integer> findPerfectNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(StreamOperations3::isPerfect)
                .boxed()
                .toList();
    }

    private boolean isPerfect(int number) {
        if (number < 2) {
            return false;
        }
        int sum = IntStream.range(1, number)
                .filter(i -> number % i == 0)
                .sum();
        return sum == number;
    }

    public static record PeoplePair(String person1, String person2) {
        @Override
        public String toString() {
            return "(" + person1 + ", " + person2 + ")";
        }
    }
}
