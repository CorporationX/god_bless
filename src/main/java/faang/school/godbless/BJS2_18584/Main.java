package faang.school.godbless.BJS2_18584;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User john = new User(1, "John", 10, Set.of("proga", "football"));
        User alice = new User(2, "Alice", 14, Set.of("basketball", "volleyball"));
        users.add(john);
        users.add(alice);

        System.out.println(User.findHobbyLovers(users, Set.of("proga","basketball")));
    }
}
