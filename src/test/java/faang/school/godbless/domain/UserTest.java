package faang.school.godbless.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Max", 34, "Luxoft", "Moscow"));
        users.add(new User("Melisa", 24, "Google", "NY"));
        users.add(new User("Bob", 54, "Epum", "SF"));
        users.add(new User("Valery", 40, "Amazon", "LA"));
        return users;
    }
}
