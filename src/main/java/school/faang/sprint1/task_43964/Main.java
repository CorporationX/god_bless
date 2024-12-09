package school.faang.sprint1.task_43964;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Anna", 22, "office", "Kazan"));
        users.add(new User("Sasha", 30, "IT", "Moscow"));
        users.add(new User("Vania", 18, "depo", "Ivanovo"));
        users.add(new User("Peter", 22, "cafe", "Berlin"));
        users.add(new User("Vasia", 22, "office", "Chicago"));

        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(users);

        groupedUsersByAge.forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(user -> System.out.println(user));
        });

    }
}