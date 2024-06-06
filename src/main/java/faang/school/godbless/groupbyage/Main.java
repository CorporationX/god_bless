package faang.school.godbless.groupbyage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.groupbyage.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice", 20, "CS", "Address1");
        User bob = new User("Bob", 20, "CS", "Address2");
        User john = new User("John", 21, "CS", "Address3");
        User rick = new User("Rick", 38, "CS", "Address4");
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
    }
}
