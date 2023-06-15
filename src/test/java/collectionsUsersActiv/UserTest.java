package collectionsUsersActiv;


import faang.school.godbless.collectors.User;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void findHobbyLoversTestTrue() {
        Set<String> set = Set.of("лыжи", "теннис");

        User user = new User(2332, "pavel", 34);
        user.setActivities(Set.of("футбол"));

        User user1 = new User(4545, "alex", 32);
        user1.setActivities(Set.of("лыжи"));

        List<User> users = List.of(user, user1);

        Map<User, String> expected = Map.of(user, "футбол", user1, "лыжи");

        Map<User, String> result = user.findHobbyLovers(users, set);

        String exp = expected.get(user1);
        String res = result.get(user1);
        assertEquals(exp, res);

    }

}
