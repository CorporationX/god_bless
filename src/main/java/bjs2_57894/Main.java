package bjs2_57894;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        Map<String, List<String>> data1 = new HashMap<>();
        insertItemToTask1(data1, "Alice", List.of("Bob", "Charlie"));
        insertItemToTask1(data1, "Bob", List.of("Alice", "David"));
        insertItemToTask1(data1, "Charlie", List.of("Alice", "David"));
        insertItemToTask1(data1, "David", List.of("Bob", "Charlie"));

        List<Pair> friendOfFriends = getFriendOfFriends(data1);
        System.out.println(friendOfFriends);
        System.out.println();

        System.out.println("Task 3");
        int from = 100;
        int to = 200;
        System.out.printf("[%d, %d]%n", from, to);
        List<Integer> palindroms = getPalindroms(from, to);
        System.out.println(palindroms);
        System.out.println();
    }

    private static void insertItemToTask1(Map<String, List<String>> data1, String name, List<String> friends) {
        data1.put(name, friends);
        System.out.printf("%s: %s%n", name, friends);
    }

    private static List<Pair> getFriendOfFriends(Map<String, List<String>> data) {
        List<Pair> sortedUniquePairs = data.entrySet()
                .stream()
                .map(kvp -> kvp.getValue()
                        .stream()
                        .map(friend -> new Pair(kvp.getKey(), friend))
                        .toList())
                .flatMap(List::stream)
                .distinct()    // Удаляем повторяющиеся пары
                .sorted(Comparator.comparing(Pair::first))
                .toList();

        Set<String> processedNames = new HashSet<>();
        List<Pair> result = new ArrayList<>();

        for (Pair pair : sortedUniquePairs) {
            String name = pair.first();
            String friendName = pair.second();

            if (processedNames.contains(name) || processedNames.contains(friendName)) {
                continue;
            }

            Optional<Pair> friendPair = sortedUniquePairs.stream()
                    .filter(p -> p.first().equals(friendName))
                    .findFirst();
            if (friendPair.isEmpty()) {
                continue;
            }

            result.add(new Pair(name, friendPair.get().second()));
            processedNames.add(friendName);
        }

        return result;
    }

    private static List<Integer> getPalindroms(int from, int to) {
        List<Integer> result = new ArrayList<>();

        List<Integer> invertedDigits = new ArrayList<>();

        int firstDigit = from;
        while (firstDigit > 0) {
            invertedDigits.add(firstDigit % 10);
            firstDigit /= 10;
        }

        for (int i = from; i <= to; i++) {
            int leftIndex = 0;
            int rightIndex = invertedDigits.size() - 1;
            while (leftIndex < rightIndex) {
                if (invertedDigits.get(leftIndex) != invertedDigits.get(rightIndex)) {
                    break;
                }

                leftIndex++;
                rightIndex--;
            }

            if (leftIndex == rightIndex) {
                result.add(i);
            }

            int j = 0;
            for (; j < invertedDigits.size() - 1; j++) {
                int digit = invertedDigits.get(j);
                if (digit < 9) {
                    invertedDigits.set(j, digit + 1);
                    break;
                } else {
                    invertedDigits.set(j, 0);
                }
            }

            if (j == invertedDigits.size() - 1 && invertedDigits.get(j) <= 9) {
                invertedDigits.set(j, invertedDigits.get(j) + 1);
            }
        }

        return result;
    }
}
