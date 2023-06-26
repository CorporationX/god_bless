package Task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestUser {

    @Test
    public void testCorrectOperationOfTheMethod() {
        // поседел над тестами, пока нет идей

        List<User> testUser = new ArrayList<>();
        Set<String> activities = new HashSet<>();

        User nikita = new User(1, "Nikita", 25, activities);
        User anna = new User(2, "Anna", 30, activities);
        User sofia = new User(3, "Sofia", 20, activities);
        User maksim = new User(4, "Maksim", 28, activities);

        testUser.add(nikita);
        testUser.add(anna);
        testUser.add(sofia);
        testUser.add(maksim);

        activities.add("basketball");
        activities.add("dance");
        activities.add("soccer");

        Map<User, String> map = User.findHobbyLovers(testUser, activities);

        Assertions.assertEquals(4, map.size());
        Assertions.assertEquals("soccer", map.get(nikita));
        Assertions.assertEquals("soccer", map.get(anna));

    }
}
