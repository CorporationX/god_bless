import faang.school.godbless.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private List<User> userList;

    @BeforeEach
    private void init() {
        userList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            userList.add(new User(
                    "User-" + i,
                    (int) (Math.random() * 40 + 18),
                    "Job-" + i,
                    "Address-" + i
            ));
        }
    }

    @Test
    public void groupUsersByAgeTest() {
        for (List<User> users : User.groupUsers(userList).values()) {
            assertTrue(users.stream()
                    .allMatch(user -> user.getAge() == users.get(0).getAge())
            );
        }
    }
}
