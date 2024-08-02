package faang.school.godbless.grouping_users_by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(5);
        users.add(new User("John", 20, "Software Engineer", "123 Main St"));
        users.add(new User("Jane", 20, "Product Manager", "456 Elm St"));
        users.add(new User("Bob", 30, "UX Designer", "789 Oak St"));
        users.add(new User("Alice", 30, "Software Engineer", "321 Pine St"));
        users.add(new User("Mike", 40, "Product Manager", "654 Cedar St"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            List<User> usersByAge = entry.getValue();
            for (User user : usersByAge) {
                System.out.println("Name: " + user.getName());
                System.out.println("Place of Work: " + user.getPlaceOfWork());
                System.out.println("Address: " + user.getAddress());
                System.out.println();
            }
        }
    }
}