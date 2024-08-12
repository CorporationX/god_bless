package faang.school.godbless.Task18546;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Adel", 24, "Microsoft", "Avenue street"),
                new User("Alina", 22, "Beta", "Main street"),
                new User("Sam", 25, "Unicorn", "Village"),
                new User("Dina", 24, "Tech", "Maple Street")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUser(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Users aged " + entry.getKey() + " years:");
            List<User> userList = entry.getValue();
            System.out.println(userList);
        }
    }
}