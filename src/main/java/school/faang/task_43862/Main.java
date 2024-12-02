package school.faang.task_43862;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Maksim", 25, "Medicine", "Belarus");
        User user2 = new User("Olga", 18, "Medicine", "USA");
        User user3 = new User("Kostya", 25, "Builder", "German");
        User user4 = new User("Sasha", 34, "Police", "France");
        User user5 = new User("Violet", 18, "Sport", "Belarus");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        System.out.println(User.groupUsers(users));
    }
}
