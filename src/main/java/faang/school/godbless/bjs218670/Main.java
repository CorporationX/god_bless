package faang.school.godbless.bjs218670;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alice", 25, "Software Engineer", "123 Maple St");
        User user2 = new User("Bob", 30, "Data Scientist", "456 Oak St");
        User user3 = new User("Charlie", 25, "Product Manager", "789 Pine St");
        User user4 = new User("Diana", 35, "UX Designer", "101 Elm St");
        User user5 = new User("Eve", 30, "DevOps Engineer", "202 Cedar St");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        System.out.println(User.groupUsers(users));
    }
}
