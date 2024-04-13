package faang.school.godbless.users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {

    private String name;

    private int age;

    private String job;

    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        Set<Integer> ages = new HashSet<>(); // будет хранить все уникальные возрасты пользователей
        for (User user : users) {
            ages.add(user.getAge());
        }

        for (Integer age : ages) {
            List<User> usersByAge = new ArrayList<>();
            for (User user : users) {
                if (age.equals(user.getAge())) {
                    usersByAge.add(user);
                }
            }
            groupUsers.put(age, usersByAge);
        }
        return groupUsers;
    }
}
