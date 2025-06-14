package school.faang.BJS2_79236;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        userList.add(new User("Алишер", 27, "Google", "Астана"));
        userList.add(new User("Алибек", 30, "Microsoft", "Алматы"));
        userList.add(new User("Жанибек", 25, "Kaspi", "Шымкент"));
        userList.add(new User("Санжар", 30, "BI Group", "Алматы"));
        userList.add(new User("Асель", 28, "Kolesa", "Астана"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(userList);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}