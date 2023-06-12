package faang.school.godbless.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class UserTest {

    @Test
    @DisplayName("Group users if match")
    void getGroupUsersTest() {
        Map<Integer, List<User>> groupUsers = User.getGroupUsers(usersMatch());
        Assertions.assertThat(groupUsers).isNotEmpty();
        Assertions.assertThat(usersMatch().get(0).getAge()).isEqualTo(34);
        Assertions.assertThat(usersMatch().get(1).getAge()).isEqualTo(24);
        Assertions.assertThat(usersMatch().get(2).getAge()).isEqualTo(54);
        Assertions.assertThat(usersMatch().get(3).getAge()).isEqualTo(40);

        Assertions.assertThat(usersMatch().get(3)).isEqualTo(new User("Valery", 40, "Amazon", "LA"));
    }

    @Test
    @DisplayName("Group users if not match age, job, address test")
    void getGroupUsersNotMatchAgeAndJobAndAddressTest() {
        Assertions.assertThatThrownBy(() -> User.getGroupUsers(usersNonMatch()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Age, job and address does not match");
    }

    private List<User> usersMatch() {
        return List.of(
            new User("Max", 34, "Luxoft", "Moscow"),
            new User("Melisa", 24, "Google", "NY"),
            new User("Bob", 54, "Epum", "SF"),
            new User("Valery", 40, "Amazon", "LA")
        );
    }

    private List<User> usersNonMatch() {
        return List.of(
            new User("Max", 14, "Luxoft", "Moscow"),
            new User("Melisa", 14, "Lombos", "NY"),
            new User("Bob", 13, "Epum", "SF"),
            new User("Valery", 16, "Babl", "LA")
        );
    }
}
