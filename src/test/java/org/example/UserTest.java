package org.example;

import faang.school.godbless.hobbyLovers.User;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    void findHobbyLoversOneObjectInResult() {

        List<User> users = new ArrayList<>();
        User user = new User(1, "BOB", 10, new HashSet<>(Arrays.asList("activity1", "activity2", "activity3")));
        users.add(user);
        users.add(new User(2, "TOM", 20, new HashSet<>(Arrays.asList("activity4", "activity5", "activity6"))));
        users.add(new User(3, "TEST", 30, new HashSet<>(Arrays.asList("activity7", "activity8", "activity3"))));

        HashSet<String> activitiesToCompare = new HashSet<>();
        activitiesToCompare.add("activity1");

        Map<User, String> res = User.findHobbyLovers(users, activitiesToCompare);
        System.out.println(res);
        assertEquals(1, res.size());
        assertTrue(res.containsKey(user));
    }

    @Test
    void findHobbyLoversResultIsEmpty() {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "BOB", 10, new HashSet<>(Arrays.asList("activity1", "activity2", "activity3"))));
        users.add(new User(2, "TOM", 20, new HashSet<>(Arrays.asList("activity4", "activity5", "activity6"))));
        users.add(new User(3, "TEST", 30, new HashSet<>(Arrays.asList("activity7", "activity8", "activity9"))));

        HashSet<String> activitiesToCompare = new HashSet<>();
        activitiesToCompare.add("activity10");

        Map<User, String> res = User.findHobbyLovers(users, activitiesToCompare);
        System.out.println(res);
        assertTrue(res.isEmpty());

    }
}