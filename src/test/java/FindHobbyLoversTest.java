import faang.school.godbless.CollectUsers.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindHobbyLoversTest {


    @Test
    public void findHobbyLovers_AllUsersInAnswer() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Test1");
        user1.setAge(12);

        user1.setActivities(new LinkedHashSet<>(Set.of("soccer","baseball","programming")));//LinkedHashSet для проверки, чтобы гарантировать порядок элементов

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Test2");
        user2.setAge(12);
        user2.setActivities(new LinkedHashSet<>(Set.of("baseball","soccer")));

        List<User> users = List.of(user1,user2);
        Set<String> activities = Set.of("soccer","baseball","programming");

        HashMap<User, String> result = User.findHobbyLovers(users, activities);


        Assertions.assertEquals(Map.of(user1, "soccer",
                user2, "baseball"),result);
    }

    @Test
    public void findHobbyLovers_NoUsersInAnswer() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Test1");
        user1.setAge(12);

        user1.setActivities(new LinkedHashSet<>(Set.of("soccer","baseball","programming")));//LinkedHashSet для проверки, чтобы гарантировать порядок элементов

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Test2");
        user2.setAge(12);
        user2.setActivities(new LinkedHashSet<>(Set.of("baseball","soccer")));

        List<User> users = List.of(user1,user2);
        Set<String> activities = Set.of();

        HashMap<User, String> result = User.findHobbyLovers(users, activities);


        Assertions.assertEquals(Map.of(),result);
    }

}
