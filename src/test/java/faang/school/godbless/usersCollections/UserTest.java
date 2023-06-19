package faang.school.godbless.usersCollections;

import faang.school.godbless.usersCollections.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserTest {
    User andrey;
    User max;
    User peter;
    List<User> users;
    List<String> hobbies;

    @BeforeEach
    void setUp() {
        hobbies = Arrays.asList("Tennis", "Volleyball", "Playing games");

        andrey = new User("Andrey", 29, Arrays.asList("Football", "Volleyball", "Basketball"));
        max = new User("Max", 36, Arrays.asList("Tennis", "Volleyball", "Basketball"));
        peter = new User("Peter", 17, Arrays.asList("Football", "Horse riding", "Basketball"));

        users = new ArrayList<>();
        users.add(andrey);
        users.add(max);
        users.add(peter);


    }

    @Test
    void testToFindHobbyLovers() {
        Map<User, String> testHobbies = new HashMap<>();
        testHobbies.put(andrey, "Volleyball");
        testHobbies.put(max, "Tennis");

        Assertions.assertEquals(testHobbies, User.findHobbyLovers(users, hobbies));
    }
}