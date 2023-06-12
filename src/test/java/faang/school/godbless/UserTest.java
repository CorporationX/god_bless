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

        Map<User,String> fhl = findHobbyLovers(users, hobbies);

        assertNotNull(fhl);
        assertNotNull(fhl.get(user3));
        assertNotNull(fhl.get(user1));
        assertEquals("Football", fhl.get(user1));
        assertEquals("Football", fhl.get(user3));
    }

}