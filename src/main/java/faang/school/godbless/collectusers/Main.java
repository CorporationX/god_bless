package faang.school.godbless.collectusers;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Name1", 20, Set.of("a", "b", "c")),
                new User(2, "Name2", 20, Set.of("b", "c", "d")),
                new User(3, "Name3", 20, Set.of("c", "d", "f")),
                new User(4, "Name4", 20, Set.of("b", "a", "f"))
        );
        Set<String> activities = Set.of("a", "b");

        Map<User, String> resultMap = User.findHobbyLovers(users, activities);
        System.out.println(resultMap);
    }
}
