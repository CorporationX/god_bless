package user;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of(
                new User("Sergey", 33, "Sber", "Omsk"),
                new User("Ivan", 25, "VK", "Moskow"),
                new User("Petr", 30, "Avito", "Spb"),
                new User("Vladislav", 33, "Uber", "Amster")
        ));

        var groupedUsers = User.groupUsers(users);

        System.out.println(groupedUsers);
    }
}
