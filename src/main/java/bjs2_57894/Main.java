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
}
