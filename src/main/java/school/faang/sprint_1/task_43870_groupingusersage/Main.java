package school.faang.sprint_1.task_43870_groupingusersage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.sprint_1.task_43870_groupingusersage.User.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ivan", 33, "Google", "London");
        User user2 = new User("Alex", 26, "Amazon", "Seattle");
        User user3 = new User("Bob", 22, "Sber", "Moscow");
        User user4 = new User("Obi", 19, "Uber", "San Francisco");
        User user5 = new User("Any", 19, "Yandex", "Moscow");
        User user6 = new User("Toby", 33, "Google", "London");
        User user7 = new User("Max", 17, "Amazon", "Seattle");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        for (Map.Entry<Integer, List<User>> entry : groupUsers(users).entrySet()) {
            System.out.println("Age: " + entry.getKey() + ". User: " + entry.getValue());
        }
    }
}