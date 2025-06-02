package school.faang.module1.bjs2_79161;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Alexey", 30, "Microsoft", "123 Main Street"),
                new User("Dmitry", 20, "Oracle", "123 Queen Street"),
                new User("Elena", 22, "Tesla", "123 Willow Boulevard"),
                new User("Ivan", 30, "Adobe", "123 Lake Road"),
                new User("Maria", 40, "IBM", "123 Forest Road"),
                new User("Nikolay", 22, "Facebook", "123 Oak Road"),
                new User("Olga", 35, "Uber", "123 Hilltop Street"),
                new User("Pavel", 30, "Spotify", "123 Mountain Street"),
                new User("Alana", 20, "LinkedIn", "123 Pine Street"),
                new User("Yaroslav", 40, "Twitter", "123 Willow Boulevard")
        );
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        groupedUsers.forEach((age, userList) -> {
            System.out.println("Возраст: " + age);
            userList.forEach(System.out::println);
            System.out.println();
        });
    }
}
