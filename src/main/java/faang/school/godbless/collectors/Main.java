package faang.school.godbless.collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = Set.of("лыжы", "тенис");

        User user = new User(2332, "pavel", 34);
        user.setActivities(Set.of("футбол"));

        User user1 = new User(4545, "alex", 32);
        user1.setActivities(Set.of("лыжы"));

        List<User> users = List.of(user, user1);

        Map<User, String> expected = Map.of(user, "футбол", user1, "лыжы");

        Map<User, String> result = user.findHobbyLovers(users, set);

        result.forEach((key, value) -> System.out.println(key.getName() + " " + value + result.size()));
    }
}
