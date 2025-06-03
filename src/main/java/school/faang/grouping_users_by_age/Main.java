package school.faang.grouping_users_by_age;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("John", 30, "microsoft", "USA"),
                new User("Mary", 25, "google", "Russia"),
                new User("Kevin", 23, "apple", "France"),
                new User("Nicholas", 22, "apple", "France"),
                new User("Nicho", 22, "apple", "France"),
                new User("Nicholas", 24, "apple", "France"));

        Map<Integer, List<User>> groupUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupUsers.entrySet()) {
            System.out.println("age " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}