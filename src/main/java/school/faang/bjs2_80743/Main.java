package school.faang.bjs2_80743;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> peoples = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        Set<Pair<String, String>> result = findNonFriendMutualPairs(peoples);
        result.forEach(System.out::println);
    }

    public static Set<Pair<String, String>> findNonFriendMutualPairs(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .flatMap(e1 ->
                        map.entrySet().stream()
                                .filter(e2 -> e1.getKey().compareTo(e2.getKey()) < 0)
                                .filter(e2 -> !e1.getValue().contains(e2.getKey()))
                                .filter(e2 -> e1.getValue().stream()
                                        .anyMatch(e2.getValue()::contains))
                                .map(e2 -> new Pair<>(e1.getKey(), e2.getKey()))
                )
                .collect(Collectors.toSet());
    }

    @EqualsAndHashCode
    public static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
}