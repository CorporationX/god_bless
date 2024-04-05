package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 25, "Developer", "Moscow"));
        users.add(new User("Peter", 30, "Manager", "Saint-Petersburg"));
        users.add(new User("Maria", 25, "Designer", "Novosibirsk"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        System.out.println(groupedUsers);
    }
}
