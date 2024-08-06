package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Application {
    public static void main(String[] args) {
        User user1 = new User("Suragan", 26, "AO CRTR", "Astana Bokeyhana 6 ");
        User user2 = new User("Nurzhan", 26, "AO Torelik", "Astana Bekturova 7 ");
        User user3 = new User("Dimash", 25, "RCEZ", "Astana Mangilik El 11");

        List<User> users = Arrays.asList(user1, user2, user3);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        groupedUsers.forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(System.out::println);
        });
    }
}