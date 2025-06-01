package school.faang.GroupingUsers_BJS2_79142;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.GroupingUsers_BJS2_79142.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Dmitry", 19, "programmer", "Sverdlova"),
                new User("Ivan", 34, "driver", "Kurchatova"),
                new User("Anna", 23, "designer", "Lenina"),
                new User("Sergey", 25, "manager", "Pushkina"),
                new User("Petr", 25, "grooving", "Pavlova")
        );
        Map<Integer, List<User>> mapResult = groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry : mapResult.entrySet()) {
            System.out.println(entry);
        }
    }
}
