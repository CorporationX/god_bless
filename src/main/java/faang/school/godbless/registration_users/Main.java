package faang.school.godbless.registration_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            List<User> users = new ArrayList<>(5);
            users.add(new User("John", 20, "Google", "London"));
            users.add(new User("Jane", 20, "Uber", "Amsterdam"));
            users.add(new User("Bob", 30, "Amazon", "New York"));
            users.add(new User("Alice", 30, "Google", "Amsterdam"));
            users.add(new User("Mike", 17, "Microsoft", "Chicago"));

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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}