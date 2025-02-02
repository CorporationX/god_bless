package school.faang.groupingusers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {
                groupedUsers.get(age).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                groupedUsers.put(age, userList);
            }
        }
        return groupedUsers;
    }

    public static void main(String[] args) {
        User user1 = new User("Natalya", 25, "Office", "g.Minsk");
        User user2 = new User("Petr", 25, "Office", "g.Moscow");
        User user3 = new User("Alex", 35, "Office", "London");

        List<User> users = Arrays.asList(user1, user2, user3);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}


