package school.faang.bjs2_85593_grouping_users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null || users.isEmpty()) {
            return new HashMap<>();
        }

        Map<Integer, List<User>> groupedUsersMap = new HashMap<>();
        for (User user : users) {
            if (user == null
                    || user.getName() == null
                    || user.getName().isEmpty()
                    || user.getAge() < 0) {
                continue;
            }

            int age = user.getAge();
            groupedUsersMap.putIfAbsent(age, new ArrayList<>());
            groupedUsersMap.get(age).add(user);
        }

        return groupedUsersMap;
    }
}