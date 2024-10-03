package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Dima", 24, "Apple", "USA"),
                new User("Misha", 31, "Amazon", "London"),
                new User("Kesha", 24, "Sber", "Moscow"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey() + " Users" + entry.getValue());
        }


    }
}
