package school.faang.task_43858;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("A", 25, "A", "A"));
        users.add(new User("B", 30, "B", "B"));
        users.add(new User("C", 30, "C", "C"));
        users.add(new User("D", 30, "D", "D"));
        users.add(new User("E", 25, "E", "E"));
        users.add(new User("F", 45, "F", "F"));

        User.groupUsers(users).forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(System.out::println);
        });
    }
}