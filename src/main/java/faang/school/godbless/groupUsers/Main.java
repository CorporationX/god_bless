package faang.school.godbless.groupUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Влад", 25, "Company A", "Main St"));
        users.add(new User("Максим", 33, "Company B", "Elm St"));
        users.add(new User("Паша", 25, "Company C", "Oak St"));
        users.add(new User("Оля", 33, "Company D", "Slave St"));
        users.add(new User("Катя", 20, "Company E", "Slave St"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        groupedUsers.forEach((age, userList) -> {
            System.out.println("Users with age " + age + ":");
            userList.forEach(user -> System.out.println(user.getName()));
        });
    }
}
