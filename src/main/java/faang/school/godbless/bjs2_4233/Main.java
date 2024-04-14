package faang.school.godbless.bjs2_4233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> activities = new HashSet<>(new HashSet<>(Arrays.asList("Soccer", "Gym", "Workout")));
        User user1 = new User(1, "Ivan", 23, new HashSet<>(Arrays.asList("Tennis", "Gym", "Ragby")));
        User user2 = new User(2, "Petr", 18, new HashSet<>(Arrays.asList("Baseball", "Camping")));
        User user3 = new User(3, "Sveta", 25, new HashSet<>(Arrays.asList("Boxing", "Workout", "Running")));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Map<User, String> userActivityMap = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : userActivityMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}
