package school.faang.bjs_46821;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamApiOperation3Test {

    @Test
    void noFriendsPair() {
        Map<String, List<String>> users = Map.of("Alice", Arrays.asList("Bob", "Charlie"),
                "Bob", Arrays.asList("Alice", "David"), "Charlie", Arrays.asList("Alice", "David"),
                "David", Arrays.asList("Bob", "Charlie"));

        Map<String, String> expected = Map.of("Alice", "David", "Bob", "Charlie");
        Map<String, String> actual = StreamApiOperation3.noFriendsPair(users);

        actual.forEach((k, v) -> {
            if (!expected.containsKey(k)) {
                assertEquals(expected.get(v), k);
            } else {
                assertEquals(expected.get(k), v);
            }
        });
    }
}