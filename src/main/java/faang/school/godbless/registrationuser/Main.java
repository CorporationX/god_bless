package faang.school.godbless.registrationuser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.registrationuser.User.groupUsers;

public class Main {

    public static void main(String[] args) {
        try {
            User alice = new User("Alice", 20, "Google", "London");
            User bob = new User("Bob", 20, "Uber", "New Yok");
            User john = new User("John", 21, "Amazon", "Amsterdam");
            User rick = new User("Rick", 38, "Goole", "London");

            List<User> users = new ArrayList<>();
            users.add(alice);
            users.add(bob);
            users.add(john);
            users.add(rick);

            Map<Integer, List<User>> groupedUsers = groupUsers(users);

            for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
                System.out.println("Age: " + entry.getKey());
                for (User user : entry.getValue()) {
                    System.out.println(user);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
