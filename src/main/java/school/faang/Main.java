package school.faang;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        User user1 = new User("Ivan", 20, "BestJob", "house 15");
        User user2 = new User("Petr", 20, "CoolWork", "house 20");
        User user3 = new User("Alex", 21, "FAANGSchool", "house 30");
        List<User> users = List.of(user1, user2, user3);

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println("age: " + entry.getKey() + "; users: " + entry.getValue());
        }
    }
}
