package main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String... args) {
        User user1 = new User("Vasya", 20, "Sber", "Moscow");
        User user2 = new User("Vasilisa", 25, "Tinkoff", "St. Petersburg");
        User user3 = new User("Vlad", 26, "Uber", "Amsterdam");
        User user4 = new User("Nastya", 23, "Ozon", "Moscow");
        User user5 = new User("Pasha", 20, "VK", "Krasnodar");

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
