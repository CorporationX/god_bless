package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.User.findHobbyLovers;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void findHobbyLoversTest() {
        User user1 = new User("Ivan", Arrays.asList("Football", "Basketball"));
        User user2 = new User("Fedor", Arrays.asList("Tennis", "Volleyball"));
        User user3 = new User("Petr", Arrays.asList("Chess", "Football"));
        List<User> users = Arrays.asList(user1, user2, user3);
        List<String> hobbies = Arrays.asList("Football", "Swimming");

        Map<User,String> foundedHobbyLovers = findHobbyLovers(users, hobbies);

        assertNotNull(foundedHobbyLovers);
        assertNotNull(foundedHobbyLovers.get(user3));
        assertNotNull(foundedHobbyLovers.get(user1));
        assertEquals("Football", foundedHobbyLovers.get(user1));
        assertEquals("Football", foundedHobbyLovers.get(user3));
    }

}