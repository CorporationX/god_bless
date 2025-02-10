package school.faang.task_56505;

import java.util.*;

import lombok.Data;

@Data
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        try {
            for (User user : users) {
                int age = user.getAge();
                groupedUsers.computeIfAbsent(age, ageKey -> new ArrayList<>()).add(user);
            }
        } catch (NullPointerException e) {
            System.out.println("Exception for users = " + e);
        }
        return groupedUsers;
    }
}
