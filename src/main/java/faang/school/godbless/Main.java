package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("a", 2, "a", "a");
        User user2 = new User("c", 3, "c", "c");
        User user3 = new User("b", 5, "b", "b");
        User user4 = new User("d", 5, "d", "d");
        List<User> users = List.of(user1, user2, user3, user4);
        Map<Integer, List<User>> result = User.groupUsers(users);
        System.out.println(result);
    }
}
