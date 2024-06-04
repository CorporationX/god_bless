package faang.school.godbless;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class UserTest {

    private static final Integer USER_AGE_18 = 18;

    @Test
    void groupUsers() {
        final Integer userAge21 = 21;
        User user1 = getUser("user1", USER_AGE_18);
        User user2 = getUser("user2", USER_AGE_18);
        User user3 = getUser("user3", userAge21);

        Map<Integer, List<User>> actual = User.groupUsers(List.of(user1, user2, user3));

        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual.get(userAge21)).contains(user3);
        assertThat(actual.get(USER_AGE_18)).contains(user1, user2);
    }

    @Test
    void throwIllegalArgumentExceptionIfMinorAge() {
        final Integer userAgeMinor = 10;
        assertThrows(IllegalArgumentException.class, () -> getUser("user1", userAgeMinor));
    }

    @Test
    void throwIllegalArgumentExceptionIfEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> getUser(null, USER_AGE_18));
        assertThrows(IllegalArgumentException.class, () -> getUser("", USER_AGE_18));
    }

    @Test
    void throwIllegalArgumentExceptionIfNotContainJob() {
        assertThrows(IllegalArgumentException.class, () -> new User("user1", USER_AGE_18, "fakeJob", "London"));
    }

    @Test
    void throwIllegalArgumentExceptionIfNotContainAddress() {
        assertThrows(IllegalArgumentException.class, () -> new User("user1", USER_AGE_18, "Google", "fakeAddress"));
    }

    private static User getUser(String name, Integer age) {
        return new User(name, age, "Google", "London");
    }
}
