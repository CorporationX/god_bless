package school.faang.task_43858;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("A", 25, "", ""));
        users.add(new User("B", 30, "", ""));
        users.add(new User("C", 30, "", ""));
        users.add(new User("D", 30, "", ""));
        users.add(new User("E", 25, "", ""));

        User.groupUsers(users).forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(System.out::println);
        });
    }
}