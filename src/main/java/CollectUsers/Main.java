package CollectUsers;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1L, "Testname", 12, Set.of("soccer", "baseball","programming"));
        User user2 = new User(2L, "Testname2", 13, Set.of("programming"));
        User user3 = new User(2L, "Testname2", 13, Set.of("gaming"));

        List<User> users = List.of(user1, user2, user3);
        Set<String> activities = Set.of("soccer", "programming");

        System.out.println(User.findHobbyLovers(users, activities));

    }
}
