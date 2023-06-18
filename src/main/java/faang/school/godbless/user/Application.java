package faang.school.godbless.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String... args) {
        User user1 = new User("Vasya", 20, "Uber", "New York");
        User user2 = new User("Vasilisa", 25, "Google", "London");
        User user3 = new User("Vlad", 26, "Uber", "Amsterdam");
        User user4 = new User("Nastya", 23, "Amazon", "New York");
        User user5 = new User("Pasha", 20, "Google", "Kjas");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        System.out.println("List: " + userList.toString());

        Map<Integer, List<User>> groupedUsers = User.group(userList);

        User.printGrouped(groupedUsers);
    }
}
