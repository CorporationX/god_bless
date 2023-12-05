package faang.school.godbless.BJS2_397;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers (List<User> userList) {

        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : userList) {
            int currentUserAge = user.getAge();
            groupedUsers.putIfAbsent(currentUserAge, new ArrayList<>());
            groupedUsers.get(currentUserAge).add(user);
        }

        return groupedUsers;
    }
}
