

import faang.school.godbless.bc223.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class UserTest {

    @Test
    void getGroupUsersTest() {
        Map<Integer, List<User>> groupUsers = User.groupUsers(getUsers());
        Assertions.assertThat(groupUsers).isNotEmpty();
        Assertions.assertThat(getUsers().get(0).getAge()).isEqualTo(25);
        Assertions.assertThat(getUsers().get(1).getAge()).isEqualTo(25);
        Assertions.assertThat(getUsers().get(2).getAge()).isEqualTo(30);
        Assertions.assertThat(getUsers().get(3).getAge()).isEqualTo(30);
        Assertions.assertThat(getUsers().get(4).getAge()).isEqualTo(5);
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Вася", 25, "mesto", "LA"));
        users.add(new User("коля", 25, "raboty", "Chita"));
        users.add(new User("галина", 30, "rabotymesto", "Gorod"));
        users.add(new User("champ", 30, "mestomesta", "neGorod"));
        users.add(new User("Джордж", 5, null, "example"));
        return users;
    }
}