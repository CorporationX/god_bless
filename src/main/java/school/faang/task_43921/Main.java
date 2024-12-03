package school.faang.task_43921;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Petya", 10, "Yandex", "Moscow"));
        users.add(new User("Vasya", 10, "Alfa-Bank", "Moscow"));
        users.add(new User("Kolya", 9, "T-Bank", "Moscow"));
        users.add(new User("Igor", 9, "Alexander and Сo", "St Petersburg"));

        var groupedUsers = User.groupUsers(users);
        groupedUsers.forEach((age, list) -> {
            System.out.println("Age: " + age);
            list.forEach(user -> System.out.println(" " + user.toString()));
        });
    }
}
