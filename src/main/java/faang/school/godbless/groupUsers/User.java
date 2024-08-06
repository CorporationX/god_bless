package faang.school.godbless.groupUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return userGroups;
    }

    public String toString() {
        return name + " (" + age + " y.o., " + company + ", " + address + ")";
    }
}
