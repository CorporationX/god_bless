package school.faang.collect_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> acti = Set.of("jump", "bike", "swim", "run", "pool");
        User user1 = new User(1, "user1", 1990, Set.of("jump", "run"));
        User user2 = new User(2, "user2", 1990, Set.of("pool", "run", "swim"));
        User user3 = new User(3, "user3", 1990, Set.of("bike"));
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Map<User, String> resultMap = User.findHobbyLovers(userList, acti);

        for (Map.Entry<User, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
