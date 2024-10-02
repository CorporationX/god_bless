package school.faang;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void groupUsers_shouldReturnGroupedUsersByAge(){
        // given
        List<User> users = List.of(
                new User("Max", 30, "Amazon", "5th avenue"),
                new User("John", 32, "Google", "3th avenue"),
                new User("Eric", 32, "Meta", "5th avenue"),
                new User("Anna", 30, "IBM", "6th avenue"),
                new User("Mia", 30, "Meta", "1th avenue"));

        // when
        Map<Integer, List<User>> expected = new HashMap<>();
        expected.put(30, List.of(
                new User("Max", 30, "Amazon", "5th avenue"),
                new User("Anna", 30, "IBM", "6th avenue"),
                new User("Mia", 30, "Meta", "1th avenue")
        ));

        expected.put(32, List.of(
                new User("John", 32, "Google", "3th avenue"),
                new User("Eric", 32, "Meta", "5th avenue")
        ));

        // then
        assertThat(expected).isEqualTo(User.groupUsers(users));
    }
}