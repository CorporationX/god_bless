package faang.school.godbless.fist_task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Misha", 20, "IT", "London");
        User user2 = new User("Sasha", 25, "IT", "London");
        User user3 = new User("Egor", 30, "IT", "London");
        User user4 = new User("Vlad", 30, "IT", "London");
        User user5 = new User("Dima", 20, "IT", "London");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        System.out.println(User.groupUsers(users));
    }
}