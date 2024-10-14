package school.faang.uniquepairs;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> groupedByFriends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        groupedByFriends.entrySet().forEach((entry) ->
                System.out.println("User: " + entry.getKey() + " | Friends: " + entry.getValue()));

        Set<List<String>> uniquePairs = UserFriends.findUniquePairs(groupedByFriends);

        uniquePairs.forEach(System.out::println);
    }
}
