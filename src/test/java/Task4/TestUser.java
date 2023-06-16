package Task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestUser {
    @Test
    public void testCorrectOperationOfTheMethod() {
        List<User> testUser = new ArrayList<>();
        List<String> manyActivities = new ArrayList<>();

        manyActivities.add("basketball");
        manyActivities.add("sing");
        manyActivities.add("soccer");
        manyActivities.add("swim");
        manyActivities.add("dance");

        testUser.add(new User(1, "Nikita", 22, manyActivities));
        testUser.add(new User(2, "Anna", 23, manyActivities));
        testUser.add(new User(3, "Sofia", 18, manyActivities));
        testUser.add(new User(4, "Anton", 22, manyActivities));
        testUser.add(new User(5, "Ben", 23, manyActivities));
        testUser.add(new User(6, "Maksim", 18, manyActivities));

        Map<User, String> map = User.findHobbyLovers(testUser, manyActivities);

        Assertions.assertEquals(testUser.get(0).getManyActivities(), manyActivities);
        Assertions.assertEquals(testUser.get(1).getManyActivities(), manyActivities);
        Assertions.assertEquals(testUser.get(2).getManyActivities(), manyActivities);
        Assertions.assertEquals(testUser.get(3).getManyActivities(), manyActivities);
        Assertions.assertEquals(testUser.get(4).getManyActivities(), manyActivities);
        Assertions.assertEquals(testUser.get(5).getManyActivities(), manyActivities);


    }
}
