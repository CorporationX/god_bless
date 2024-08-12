package org.example;

import faang.school.godbless.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.userGrouping.User.groupUsers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnotherUserTest {

    @Test
    void creationIncorrectAgeUserTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("BOB", 10, "Uber", "Amsterdam"),
                "Age couldn't be less than 18");
    }

    @Test
    void creationIncorrectNameUserTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new User(null, 18, "Uber", "Amsterdam"),
                "Name couldn't be empty");

        assertThrows(IllegalArgumentException.class,
                () -> new User("               ", 18, "Uber", "Amsterdam"),
                "Name couldn't be empty");
    }

    @Test
    void creationIncorrectJobUserTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("BOB", 18, "Unknown", "Amsterdam"),
                "Job should be from [Amazon, Uber, Google]");
    }

    @Test
    void creationIncorrectAddressUserTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("BOB", 18, "Amazon", "Russia"),
                "Address should be from [New York, London, Amsterdam]");
    }

    @Test
    void creationCorrectUserTest() {
        User user = new User("BOB", 18, "Amazon", "London");
        assertEquals(user, new User("BOB", 18, "Amazon", "London"));
    }

    @Test
    void groupUsersTest() {
        List<faang.school.godbless.userGrouping.User> users = new ArrayList<>();
        faang.school.godbless.userGrouping.User user = new faang.school.godbless.userGrouping.User("BOB", 10, "Test", "Test");
        faang.school.godbless.userGrouping.User user1 = new faang.school.godbless.userGrouping.User("TOM", 10, "Test", "Test");
        faang.school.godbless.userGrouping.User user2 = new faang.school.godbless.userGrouping.User("TEST", 20, "Test", "Test");
        users.add(user);
        users.add(user1);
        users.add(user2);

        Map<Integer, List<faang.school.godbless.userGrouping.User>> res = groupUsers(users);
        assertEquals(2, res.size());
    }
}
