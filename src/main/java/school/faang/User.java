package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.putIfAbsent(user.getAge(), new ArrayList<>());
            userGroups.get(user.getAge()).add(user);
        }
        return userGroups;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 25, "Google",
                "Wakanda"));
        users.add(new User("John", 29, "Amazon",
                "Anor londo"));
        users.add(new User("Vlad", 25, "Uber",
                "Rohan"));
        users.add(new User("Katya", 49, "Facebook",
                "Mordor"));

        Map<Integer, List<User>> userGroups = groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : userGroups.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
