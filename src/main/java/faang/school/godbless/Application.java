package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String... args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 26, "Google", "Los-Angeles"));
        users.add(new User("Andrey", 28, "FAANG-School", "Amsterdam"));
        users.add(new User("Misha", 28, "Corporation-X", "Berlin"));
        users.add(new User("Lui", 26, "MTC", "Saratov"));
        users.add(new User("Olga", 24, "Yandex", "Moscow"));
        users.add(new User("Kristina", 24, "Uber", "Keln"));

        Map<Integer, List<User>> resultGroupUsers = User.groupUsers(users);
        System.out.println(resultGroupUsers);
        System.out.println(users.get(0));
        System.out.println(resultGroupUsers.get(26).get(0));
        System.out.println(users.get(1));
        System.out.println(resultGroupUsers.get(28).get(0));
        System.out.println(users.get(2));
        System.out.println(resultGroupUsers.get(28).get(1));
        System.out.println(users.get(3));
        System.out.println(resultGroupUsers.get(26).get(1));
        System.out.println(users.get(4));
        System.out.println(resultGroupUsers.get(24).get(0));
        System.out.println(users.get(5));
        System.out.println(resultGroupUsers.get(24).get(1));

    }
}
