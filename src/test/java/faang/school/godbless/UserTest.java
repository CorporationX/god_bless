package faang.school.godbless;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class UserTest {

    private static Integer USER_AGE_18 = 18;

    @Test
    void groupUsers() {
        User user1 = getUser("user1", USER_AGE_18);
        User user2 = getUser("user2", USER_AGE_18);
        User user3 = getUser("user3", 12);

        Map<Integer, List<User>> actual = User.groupUsers(List.of(user1, user2, user3));

        Assertions.assertThat(actual.size()).isEqualTo(2);
        Assertions.assertThat(actual.get(12)).contains(user3);
        Assertions.assertThat(actual.get(18)).contains(user1, user2);
    }

    private static User getUser(String name, Integer age) {
        return new User(name, age, "komiac", "Новокузнецк");
    }
}