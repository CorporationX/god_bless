package faang.school.godbless.user_registration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Bob", 21, "Google", "New York");
        User user2 = new User("Lisa", 23, "Amazon", "London");
        User user3 = new User("Tod", 24, "Uber", "Amsterdam");
        User user5 = new User("Sam", 27, "Google", "New York");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user5);

        System.out.println(User.groupUsers(users));

    }
}
