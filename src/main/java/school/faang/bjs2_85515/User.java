package school.faang.bjs2_85515;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    protected static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        if (users == null || users.isEmpty()) {
            return groupUsers;
        }

        for (User user : users) {
            int age = user.getAge();

            if (!groupUsers.containsKey(age)) {
                groupUsers.put(age, new ArrayList<>());
            }

            groupUsers.get(age).add(user);
        }

        return groupUsers;
    }

    protected static void printUsers(Map<Integer, List<User>> groupedUsers) {
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст " + entry.getKey() + ": " + entry.getValue().size() + " пользователей");

            for (User user : entry.getValue()) {
                System.out.println(" - " + user.getName());
            }
        }
    }
}
