package faang.school.godbless.collectingusers;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void findHobbyLovers() {
        User user1 = new User(1, "user1", 5, new LinkedHashSet<>(List.of("running", "programming")));
        User user2 = new User(2, "user2", 5, new LinkedHashSet<>(List.of("programming")));
        User user3 = new User(3, "user3", 5, new LinkedHashSet<>(List.of("swimming")));
        User user4 = new User(4, "user4", 5, new LinkedHashSet<>(List.of("swimming")));

        Map<User, String> actual = user1.findHobbyLovers(List.of(user1, user2, user3, user4), new LinkedHashSet<>(List.of("running", "programming")));

        assertThat(actual).hasSize(2);
        assertThat(actual.keySet()).contains(user1, user2);
    }

    @Test
    void checkFirstMatchingUserActivity() {
        User user1 = new User(1, "user1", 5, new LinkedHashSet<>(List.of("flying", "programming", "running")));
        User user2 = new User(2, "user2", 5, new LinkedHashSet<>(List.of("flying")));
        User user3 = new User(3, "user3", 5, null);
        User user4 = new User(4, "user4", 5, Collections.emptySet());

        Map<User, String> actual = user1.findHobbyLovers(List.of(user1, user2, user3, user4), new LinkedHashSet<>(List.of("swimming", "running", "programming")));

        assertThat(actual).hasSize(1);
        assertThat(actual.get(user1)).isEqualTo("programming");
    }
}