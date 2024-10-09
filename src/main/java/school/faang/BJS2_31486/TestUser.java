package school.faang.BJS2_31486;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestUser {
    public static void main(String[] args) {
        User user1 = new User("David", 25, "Google", "125 westheimer road");
        User user2 = new User("John", 26, "Meta", "65 McCue road");
        User user3 = new User("Bruno", 44, "Amazon", "56 Alberene road");
        User user4 = new User("James", 25, "Microsoft", "69 Honeywell road");
        User user5 = new User("Alan", 44, "SalesForce", "54 Rice road");
        User user6 = new User("Frank", 36, "Deloitte", "85 Gessner road");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        Map<Integer, List<User>> groupByAge = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupByAge.entrySet()) {
            System.out.println("Age: " + entry.getKey() + "-> Users: " + entry.getValue());
        }
    }
}
