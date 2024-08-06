package faang.school.godbless.collect_users;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest {

    @ParameterizedTest
    @MethodSource("findHobbyLoversProvider")
    void findHobbyLovers(List<User> users, Set<String> activities, List<User> keys) {
        var result = User.findHobbyLovers(users, activities);
        assertThat(result).containsKey(keys.getFirst());
        assertThat(result).containsKey(keys.get(1));
        assertThat(result).containsKey(keys.get(2));
        assertThat(result).doesNotContainKey(keys.getLast());
    }

    private Stream<Arguments> findHobbyLoversProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new User(1, "Alice", 25, Set.of("reading", "swimming", "gaming")),
                                new User(2, "Bob", 30, Set.of("running", "gaming", "hiking")),
                                new User(3, "Charlie", 35, Set.of("cycling", "swimming", "cooking")),
                                new User(4, "Bob", 33, Set.of("Sleeping", "Walking", "Eating"))
                        ),
                        Set.of("reading", "swimming", "gaming"),
                        List.of(
                                new User(1, "Alice", 25, Set.of("reading", "swimming", "gaming")),
                                new User(2, "Bob", 30, Set.of("running", "gaming", "hiking")),
                                new User(3, "Charlie", 35, Set.of("cycling", "swimming", "cooking")),
                                new User(4, "Bob", 33, Set.of("Sleeping", "Walking", "Eating"))
                        )
                )
        );
    }
}