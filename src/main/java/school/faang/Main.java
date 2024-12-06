package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Arman", 20, "Google", "123"),
                new User("Dias", 21, "Amazon", "456"),
                new User("Artem", 22, "Microsoft", "789")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        groupedUsers.forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(System.out::println);
            System.out.println();
        });
    }
}
