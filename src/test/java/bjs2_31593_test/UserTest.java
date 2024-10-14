package bjs2_31593_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.m1s1.bjs2_31593_collecting_users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(1, "user1", 20, Set.of("h1", "h2", "h3"));
    }

    @Test
    void testFindHobbieLovers() {
        List<User> userList = new ArrayList<>(List.of(
                new User(2, "user2", 20, Set.of("h1", "h3", "h2")),
                new User(3, "user3", 20, Set.of("h4")),
                new User(4, "user4", 20, Set.of("h3", "h4"))
        ));

        Map<User, String> result = user.findHobbieLovers(userList, user.getHobbies());

        assertEquals(2, result.size());
        assertEquals("h3", result.get(new User(4, "user4", 20, Set.of("h3", "h4"))));
    }
}

