package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //User.groupUsers();

        List<User> list = Arrays.asList(
                new User("Sasha", 25, "VK", "Moscow"),
                new User("Behzod", 24, "MTC", "S.Petersburg"),
                new User("Masha", 30, "Sber", "Kazan"));

        Map<Integer, List<User>> groupedUser = User.groupUsers(list);

        groupedUser.forEach((age, users) -> {
            System.out.println(age + ":");
            users.forEach(user -> System.out.println("Name: " + user.getName()));
            System.out.println();
        });

    }
}