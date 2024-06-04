package faang.school.godbless.BJS2_7533;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Anna", 19, "Yandex", "Moscow"));
        users.add(new User("Kolya", 20, "Sber", "Moscow"));
        users.add(new User("Tom", 19, "Google", "Frankfurt"));
        users.add(new User("Alya", 20, "Aston", "Moscow"));

        Map<Integer, List<User>> usersByAge = User.groupUsers(users);
        usersByAge.forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(System.out::println);
        });
    }
}
