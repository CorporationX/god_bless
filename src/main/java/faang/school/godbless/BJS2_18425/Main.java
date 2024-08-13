package faang.school.godbless.BJS2_18425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alice", 21, new HashSet<>(Arrays.asList("dancing", "coding"))));
        users.add(new User(2L, "Max", 25, new HashSet<>(Arrays.asList("reading", "swimming"))));
        users.add(new User(3L, "Nikita", 23, new HashSet<>(Arrays.asList("dancing", "reading"))));
        Set<String> activities = new HashSet<>(Arrays.asList("coding", "swimming"));
        Map<User, String> usersActivities = User.findHobbyLovers(users, activities);
        for (var userActivity : usersActivities.entrySet()) {
            System.out.println(userActivity.getKey().getName() + " " + userActivity.getValue());
        }
    }
}
