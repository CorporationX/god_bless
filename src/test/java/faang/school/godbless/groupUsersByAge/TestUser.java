package faang.school.godbless.groupUsersByAge;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUser {

    @Test
    void groupUsers(){
        List<User> users = List.of(
                new User("John", 32, "Amazon", "New-York"),
                new User("Erick", 32, "Facebook", "Los-Angeles"),
                new User("Bred", 31, "Amazon", "New-York"),
                new User("John", 31, "Facebook", "Los-Angeles"),
                new User("Seth", 30, "Amazon", "New-York"),
                new User("Palmer", 30, "Facebook", "Las-Vegas"),
                new User("Eddy", 35, "Amazon", "Las-Vegas"),
                new User("Christopher", 35, "Facebook", "Los-Angeles"),
                new User("Kenny", 28, "Amazon", "Las-Vegas"),
                new User("Collin", 28, "Facebook", "Las-Vegas")
        );

        Map<Integer, List<User>> usersToGroup = User.groupUsers(users);
            assertEquals(5, usersToGroup.size());
        assertTrue(usersToGroup.containsKey(32));
        assertTrue(usersToGroup.containsKey(31));
        assertTrue(usersToGroup.containsKey(30));
        assertTrue(usersToGroup.containsKey(35));
        assertTrue(usersToGroup.containsKey(28));
        }
}