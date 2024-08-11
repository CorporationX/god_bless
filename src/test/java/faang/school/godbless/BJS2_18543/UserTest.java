package faang.school.godbless.BJS2_18543;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class UserTest {

    @Test
    void findHobbyLovers() {
        Set<String> activities = Set.of("reading", "swimming", "gaming");
        List<User> users = List.of(
                new User(1, "Alice", 25, Set.of("reading", "swimming", "gaming")),
                new User(2, "Bob", 30, Set.of("running", "gaming", "hiking")),
                new User(3, "Charlie", 35, Set.of("cycling", "swimming", "cooking")),
                new User(4, "Bob", 33, Set.of("Sleeping", "Walking", "Eating"))
        );
        List<User> expectedKeys = List.of(
                new User(1, "Alice", 25, Set.of("reading", "swimming", "gaming")),
                new User(2, "Bob", 30, Set.of("running", "gaming", "hiking")),
                new User(3, "Charlie", 35, Set.of("cycling", "swimming", "cooking")),
                new User(4, "Bob", 33, Set.of("Sleeping", "Walking", "Eating"))
        );
        var result = User.findHobbyLovers(users, activities);

        assertThat(result).containsKey(expectedKeys.get(0));
        assertThat(result).containsKey(expectedKeys.get(1));
        assertThat(result).containsKey(expectedKeys.get(2));
        assertThat(result).doesNotContainKey(expectedKeys.get(3));
    }

}