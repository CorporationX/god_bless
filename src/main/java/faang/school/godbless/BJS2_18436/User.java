package faang.school.godbless.BJS2_18436;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }
}
