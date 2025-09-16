package school.faang.m1.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    1️⃣ Найдите людей с общими друзьями
    На вход дана Map, где ключи — это имена людей, а значения — списки их друзей.
    Нужно найти все пары людей, которые не являются друзьями, но имеют общих друзей.
 */
public class StreamStageThree {
    public static void main(String[] args) {
        var friends = Map.of(
                "Alice",   List.of("Bob", "Charlie"),
                "Bob",     List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David",   List.of("Bob", "Charlie")
        );

        System.out.println(nonFriendsWithMutuals(friends));
    }

    public record Pair(String a, String b) {
        public static Pair of(String x, String y) {
            return (x.compareTo(y) <= 0) ? new Pair(x, y) : new Pair(y, x);
        }
    }

    public static Set<Pair> nonFriendsWithMutuals(Map<String, List<String>> input) {
        // adjacency как Set + симметризация
        Map<String, Set<String>> adj = input.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> new HashSet<>(e.getValue())
                ));
        adj.forEach((p, fs) -> fs
                .forEach(f -> adj.computeIfAbsent(f, k -> new HashSet<>()).add(p)));
        adj.forEach((p, fs) -> fs.remove(p));

        return adj.entrySet().stream()
                .flatMap(e -> {
                    List<String> friends = new ArrayList<>(e.getValue());
                    int n = friends.size();
                    return IntStream.range(0, n).boxed()
                            .flatMap(i -> IntStream.range(i + 1, n)
                                    .mapToObj(j -> Pair.of(friends.get(i), friends.get(j))));
                })
                .filter(p -> !adj.getOrDefault(p.a(), Set.of()).contains(p.b()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
