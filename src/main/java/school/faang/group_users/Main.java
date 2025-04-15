package school.faang.group_users;

import school.faang.group_users.models.User;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Nik", 50, "SperBankMoney", " Money St 777"),
                new User("cucumber", 20, "Banduel", "vegetable 15 st"),
                new User("tomato", 20, "Banduel", "vegetable 15 st")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        groupedUsers.forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(user -> System.out.println("  - " + user.getName()));
        });
    }
}
