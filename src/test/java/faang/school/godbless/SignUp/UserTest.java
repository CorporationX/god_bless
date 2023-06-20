package faang.school.godbless.SignUp;

import faang.school.godbless.SignUp.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static faang.school.godbless.SignUp.User.groupUsers;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsersTest() {
        User user1 = new User("first", 20, "Google", "London");
        User user2 = new User("second", 25, "Google", "London");
        User user3 = new User("third", 20, "Google", "London");
        List<User> userList = List.of(user1, user2, user3);

        Map<Integer, List<User>> map = groupUsers(userList);

        assertNotNull(map);
        assertEquals(2, map.size());
        assertEquals(2, map.get(20).size());
        assertEquals(1, map.get(25).size());
    }

    @Test
    void messageValidation() {
        String wrongName = "Name can't be empty";
        String wrongAge = "Age can't be less then 18";
        String wrongJob = "Job should be Google, Uber, Amazon";
        String wrongAddress = "Address should be London, New York, Amsterdam";

        IllegalArgumentException nameException = assertThrows(IllegalArgumentException.class, () -> new User("", 20, "Google", "London"));
        IllegalArgumentException ageException = assertThrows(IllegalArgumentException.class, () -> new User("Tim", 17, "Google", "London"));
        IllegalArgumentException jobException = assertThrows(IllegalArgumentException.class, () -> new User("Tim", 20, "Meta", "London"));
        IllegalArgumentException addressException = assertThrows(IllegalArgumentException.class, () -> new User("Tim", 20, "Google", "Moscow"));

        assertEquals(wrongName, nameException.getMessage());
        assertEquals(wrongAge, ageException.getMessage());
        assertEquals(wrongJob, jobException.getMessage());
        assertEquals(wrongAddress, addressException.getMessage());
    }
}