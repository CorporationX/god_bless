package faang.school.godbless.collectUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String... args) {
        User user1 = new User(1, "Vasya", 21, Set.of("Skiing", "Tennis"));
        User user2 = new User(2, "Nastya", 23, Set.of("Beer"));
        User user3 = new User(3, "Vlad", 24, Set.of("Football"));
        User user4 = new User(4, "Pasha", 24, Set.of("Chess", "Tennis", "Beer"));
        List<User> userList = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));

        System.out.println(userList);

        var ans = User.findHobbyLovers(userList, Set.of("Beer"));
        for (var entry : ans.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
