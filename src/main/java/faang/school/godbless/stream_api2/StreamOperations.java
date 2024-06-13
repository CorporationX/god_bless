package faang.school.godbless.stream_api2;

import lombok.NonNull;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamOperations {
    public static List<List<Integer>> pairConstructor(@NonNull List<Integer> integers, int sum) {
        Set<Integer> set = new HashSet<>();
        return integers.stream()
                .distinct()
                .flatMap(integer -> {
                    if (set.contains(sum - integer)) {
                        return Stream.of(List.of(sum - integer, integer));
                    } else {
                        set.add(integer);
                        return Stream.empty();
                    }
                }).toList();
    }

    public static void showCountriesAndCapitals(@NonNull Map<String, String> countryCapital) {
        countryCapital.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }

    public static List<String> filterBeginsWithAndSortByLength(@NonNull List<String> strings,
                                                               char letter) {
        return strings.stream()
                .filter(string -> string.toLowerCase().startsWith(String.valueOf(letter).toLowerCase()))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Set<List<String>> findUnknownFriends(@NonNull Map<String, List<String>> friends) {
        Set<List<String>> farFriends = new HashSet<>();

        friends.keySet().forEach(primaryFriendName -> {
            Map<String, Boolean> isProcessed = new HashMap<>();
            Queue<FriendWalkingNode> queue = new LinkedList<>();
            FriendWalkingNode node = new FriendWalkingNode(primaryFriendName, primaryFriendName, 0);
            queue.add(node);

            while (!queue.isEmpty()) {
                FriendWalkingNode nodeToProcess = queue.poll();
                String friendToProcessName = nodeToProcess.getName();
                int depth = nodeToProcess.getDepth();
                isProcessed.put(friendToProcessName, true);

                for (String friendName : friends.get(friendToProcessName)) {
                    if (!isProcessed.getOrDefault(friendName, false)) {
                        queue.add(new FriendWalkingNode(friendName, primaryFriendName, depth + 1));
                        if (depth >= 1) {
                            farFriends.add(Stream.of(friendName, primaryFriendName).sorted().toList());
                        }
                    }
                }
            }
        });

        return farFriends;
    }

    public static Map<String, Double> getAverageSalaryByDepartment(@NonNull List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    public static List<String> filterByAlphabetAndSortByLength(@NonNull List<String> strings,
                                                               @NonNull String alphabet) {
        return strings.stream()
                .filter(string -> {
                    boolean result = true;
                    for (int i = 0; i < string.length(); i++) {
                        result &= alphabet.indexOf(string.charAt(i)) != -1;
                    }
                    return result;
                })
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> binaryConverter(@NonNull List<Integer> integers) {
        return integers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findPalindromeIntegersInRange(int lowerBound, int upperBound) {
        return IntStream.rangeClosed(lowerBound, upperBound)
                .filter(integer -> String.valueOf(integer).contentEquals(new StringBuilder(String.valueOf(integer)).reverse()))
                .boxed()
                .toList();
    }

    public static Set<String> findAllPalindromesInString(@NonNull String originalString) {
        return IntStream.range(0, originalString.length())
                .boxed()
                .flatMap(integer -> IntStream.range(integer + 1, originalString.length())
                        .mapToObj(end -> originalString.substring(integer, end + 1)))
                .filter(string -> string.contentEquals(new StringBuilder(string).reverse()))
                .collect(Collectors.toSet());
    }

    public static List<Integer> findAllPerfectNumbersInRange(int start, int end) {
        if (start <= 1) {
            start = 2;
        }
        return IntStream.rangeClosed(start, end)
                .filter(integer -> countSumOfDivisors(integer) == integer)
                .boxed()
                .toList();
    }

    private static int countSumOfDivisors(int divisible) {
        int sum = 1;
        for (int i = 2; i * i <= divisible; i++) {
            if (divisible % i == 0) {
                sum += i;
                if (divisible / i != i) {
                    sum += divisible / i;
                }
            }
        }
        return sum;
    }
}
