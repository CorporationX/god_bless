import faang.school.godbless.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private List<User> users;

    @BeforeEach
    void setUp() {
        users = List.of(
                new User("Petr", 11,"CorparetionX","ulica"),
                new User("Petr", 22,"CorparetionX","ulica"),
                new User("Petr", 33,"CorparetionX","ulica"),
                new User("Petr", 2,"CorparetionX","ulica")
        );
    }

    @Test
    void groupUsers() {
        assertEquals(4, User.groupUsers(users).size());
    }

}
