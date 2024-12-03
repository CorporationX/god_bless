package school.faang.module1.task43503;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Semyon", 31, "Lamoda", "Peter");
        User user2 = new User("Vlad", 28, "Alfa", "Peter");
        User user3 = new User("Fedor", 35, "Lamoda", "Peter");
        User user4 = new User("John", 35, "Lamoda", "Peter");

        List<User> users = new ArrayList<>(Arrays.asList(
                user1, user2, user3, user4
        ));

        Map<Integer, List<User>> sortedUser = User.groupUsers(users);

        System.out.println(sortedUser);

    }
}
