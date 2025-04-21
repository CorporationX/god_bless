package school.faang.streamapithree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class TrainingStreamApi {

    public static List<Pair<String, String>> findNonFriendPairs(
            Map<String, List<String>> peopleAndTheirFriends) {

        Set<String> people = peopleAndTheirFriends.keySet();
        return peopleAndTheirFriends.entrySet().stream()
                .flatMap(entry -> {
                    String person = entry.getKey();
                    List<String> friends = entry.getValue();
                    return people.stream().filter(other -> !other.equals(person)
                                    && !friends.contains(other))
                            .filter(other -> {
                                List<String> otherFriends = peopleAndTheirFriends.getOrDefault(other, List.of());
                                return otherFriends.stream().anyMatch(friends::contains);
                            })
                            .filter(other -> person.compareTo(other) < 0)
                            .map(other -> new Pair<>(person, other));
                })
                .toList();
    }

    public static Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<Integer> findPalindromicNumbersInRange(int a, int b) {
        return IntStream.range(a, b)
                .filter(v -> String.valueOf(v).contentEquals(new StringBuilder(String.valueOf(v)).reverse()))
                .boxed()
                .toList();
    }

    public static Set<String> findPalindromicSubstrings(String str) {
        Set<String> allPalindromes = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            stringBuilder.append("#").append(c);
        }
        stringBuilder.append("#");

        String s = stringBuilder.toString();
        int[] p = new int[s.length()];
        int r = 0;
        int c = 0;
        int left;
        int right;

        for (int i = 1; i < s.length(); i++) {
            if (i < r && i > c) {
                int mirror = 2 * c - i;
                p[i] = Math.min(p[mirror], r - i);
            }
            left = i - (p[i] + 1);
            right = i + (p[i] + 1);
            while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                p[i]++;
                left--;
                right++;
            }
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
            for (int len = 1; len <= p[i]; len++) {
                int start = (i - len) / 2;
                int end = start + len;
                allPalindromes.add(str.substring(start, end));
            }
        }
        return allPalindromes;
    }

    public static List<Integer> findPerfectNumbersInRange(int a, int b) {
        List<Integer> perfectNumbers = new ArrayList<>();
        for (int num = a; num <= b; num++) {
            int sum = 1;
            for (int j = 2; j <= (int) Math.sqrt(num); j++) {
                if (num % j == 0) {
                    sum = sum + j;
                    int pair = num / j;
                    if (pair != j && pair != num) {
                        sum += pair;
                    }
                }
            }
            if (sum == num && num != 1) {
                perfectNumbers.add(num);
            }
        }
        return perfectNumbers;
    }
}
