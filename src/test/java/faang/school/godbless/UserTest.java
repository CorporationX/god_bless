package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void findHobbyLovers() {
        User user1 = new User(1, "user1", 5, new HashSet<>(List.of("running", "programming")));
        User user2 = new User(2, "user2", 5, new HashSet<>(List.of("programming")));
        User user3 = new User(3, "user3", 5, new HashSet<>(List.of("swimming")));
        User user4 = new User(4, "user4", 5, new HashSet<>(List.of("swimming")));

        Map<User, String> actual = user1.findHobbyLovers(List.of(user1, user2, user3, user4), new HashSet<>(List.of("running", "programming")));

        assertThat(actual).hasSize(2);
        assertThat(actual.keySet()).contains(user1, user2);
    }
}