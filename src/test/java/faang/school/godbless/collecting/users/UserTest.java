package faang.school.godbless.collecting.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserTest {

    @Test
    void testFindHobbyLovers() {

        User tom = new User(1, "Tom", 28, Set.of("football", "music", "movie"));
        User max = new User(2, "Max", 38, Set.of("cars", "sport", "movie"));
        User mary = new User(3, "Mary", 28, Set.of("music", "dogs", "photography"));
        User artur = new User(4, "Artur", 39, Set.of("music", "sport"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(List.of(tom, max, mary, artur), Set.of("cars", "sport"));
        Assertions.assertEquals(2, hobbyLovers.size());
        Assertions.assertTrue(hobbyLovers.containsKey(max));
        Assertions.assertTrue(hobbyLovers.containsKey(artur));
    }
}
