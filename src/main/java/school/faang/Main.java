package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Nikita", 21, "Google", "London"),
                new User("Vlad", 21, "Google", "London"),
                new User("Dima", 17, "Uber", "Amsterdam"),
                new User("Katia", 22, "Amazon", "London"),
                new User("Maxim", 33, "Amazon", "Amsterdam")
        );

        System.out.println(users);

        Map<Integer, List<User>> groupUser = User.groupUsers(users);

        System.out.println(groupUser);
    }
}
