package faang.school.godbless.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class UserTest {

    @Test
    void getGroupUsersTest() {
        Map<Integer, List<User>> groupUsers = User.getGroupUsers(getUsers());
        Assertions.assertThat(groupUsers).isNotEmpty();
        Assertions.assertThat(getUsers().get(0).getAge()).isEqualTo(34);
        Assertions.assertThat(getUsers().get(1).getAge()).isEqualTo(24);
        Assertions.assertThat(getUsers().get(2).getAge()).isEqualTo(54);
        Assertions.assertThat(getUsers().get(3).getAge()).isEqualTo(40);

        Assertions.assertThat(getUsers().get(3)).isEqualTo(new User("Valery", 40, "Amazon", "LA"));
    }

    private List<User> getUsers() {
        return List.of(
            new User("Max", 34, "Luxoft", "Moscow"),
            new User("Melisa", 24, "Google", "NY"),
            new User("Bob", 54, "Epum", "SF"),
            new User("Valery", 40, "Amazon", "LA")
        );
    }
}
