package faang.school.godbless.streamapi2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class StreamApi2Test {

    @Test
    void findNames() {
        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("Alice", asList("Bob", "Charlie", "David"));
        friendships.put("Bob", asList("Alice", "Eve"));
        friendships.put("Charlie", asList("Alice", "Eve"));
        friendships.put("David", asList("Alice"));
        friendships.put("Eve", asList("Bob", "Charlie"));
        var actualResult = StreamApi2.findNames(friendships);

        assertThat(actualResult).hasSize(4);
        actualResult.forEach(System.out::println);
    }

    @Test
    void createOrderedPairTest() throws Exception {

        StreamApi2 streamApi2 = new StreamApi2();

        var method = StreamApi2.class.getDeclaredMethod("createOrderedPair", String.class, String.class);
        method.setAccessible(true);

        var result1 = (String) method.invoke(streamApi2, "Alice", "Bob");
        var result2 = (String) method.invoke(streamApi2, "Bob", "Alice");

        assertThat(result1).isEqualTo(result2);
        System.out.println(result1);
        System.out.println(result2);


    }
}