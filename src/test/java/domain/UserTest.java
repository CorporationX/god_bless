package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserTest {
    @Test
    public void shouldReturnSortedMapByAge() {
        Map<Integer, List<User>> usersGroup = User.groupUsers(getUsers());
        Assertions.assertThat(usersGroup).isNotEmpty();

        Assertions.assertThat(getUsers().get(0).getAge()).isEqualTo(23);
        Assertions.assertThat(getUsers().get(1).getAge()).isEqualTo(23);
        Assertions.assertThat(getUsers().get(2).getAge()).isEqualTo(19);
        Assertions.assertThat(getUsers().get(3).getAge()).isEqualTo(19);
        Assertions.assertThat(getUsers().get(4).getAge()).isEqualTo(25);
        Assertions.assertThat(getUsers().get(5).getAge()).isEqualTo(29);
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Arman", 23, "programmer", "1212"));
        users.add(new User("Oleg", 23, "programmer", "1212"));
        users.add(new User("Gold", 19, "programmer", "1212"));
        users.add(new User("Mark", 19, "programmer", "1212"));
        users.add(new User("Sasha", 25, "programmer", "1212"));
        users.add(new User("Olga", 29, "programmer", "1212"));

        return users;
    }
}
