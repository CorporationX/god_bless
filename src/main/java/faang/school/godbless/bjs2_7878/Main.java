package faang.school.godbless.bjs2_7878;

import faang.school.godbless.bjs2_7565.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            User user1 = new User("Vlad", 36, "Google", "London");
            User user2 = new User("Nikolay", 30, "Google", "London");
            User user3 = new User("Olga", 24, "Google", "London");
            User user4 = new User("Evgeniy", 36, "Uber", "London");
            User user5 = new User("Mikhail", 24, "Amazon", "London");
            User user6 = new User("Artur", 30, "Uber", "London");
            User user7 = new User("Katya", 30, "Google", "London");
            User user8 = new User("Svetlana", 19, "Amazon", "London");
            User user9 = new User("Egor", 24, "Uber", "London");
            User user10 = new User("Ilya", 20, "Amazon", "London");

            List<User> users = new ArrayList<>();

            users.add(user1);
            users.add(user2);
            users.add(user3);
            users.add(user4);
            users.add(user5);
            users.add(user6);
            users.add(user7);
            users.add(user8);
            users.add(user9);
            users.add(user10);

            for (Map.Entry entry : User.groupUsers(users).entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
