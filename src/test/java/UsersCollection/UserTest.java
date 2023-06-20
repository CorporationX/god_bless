package UsersCollection;

import faang.school.godbless.UsersCollection.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.UsersCollection.User.findHobbyLovers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {

    @Test
    void findHobbyLoversTest() {
        User user1 = new User("Ivan", Arrays.asList("Football", "Basketball"));
        User user2 = new User("Fedor", Arrays.asList("Tennis", "Volleyball"));
        User user3 = new User("Petr", Arrays.asList("Chess", "Football"));
        User user4 = new User("Alexandr", null);
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        List<String> hobbies = Arrays.asList("Football", "Swimming");

        Map<User, String> foundedHobbyLovers = findHobbyLovers(users, hobbies);

        assertNotNull(foundedHobbyLovers);
        assertNotNull(foundedHobbyLovers.get(user3));
        assertNotNull(foundedHobbyLovers.get(user1));
        assertEquals("Football", foundedHobbyLovers.get(user1));
        assertEquals("Football", foundedHobbyLovers.get(user3));
    }

}