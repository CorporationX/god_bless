package faang.school.godbless.BJS2_4627;
import static faang.school.godbless.BJS2_4627.User.groupUsers;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 26, "LA", "2032"));
        users.add(new User("Misha", 27, "LA", "2032"));
        users.add(new User("Dima", 20, "NY", "2032"));
        users.add(new User("Alex", 28, "Boston", "2032"));

        Map<Integer, List<User>> result = groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            System.out.println(entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }
    }
}
