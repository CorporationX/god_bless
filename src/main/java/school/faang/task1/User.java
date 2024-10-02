package school.faang.task1;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static void addUserToList(List<User> users, User user) {
        users.add(user);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new TreeMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

    public static void printGroupedUsers(Map<Integer, List<User>> groupedUsers) {
        System.out.println("USERS GROUPED BY AGE");
        for (Integer age : groupedUsers.keySet()) {
            System.out.println("Age:" + age);
            for (User user : groupedUsers.get(age)) {
                System.out.println("\t" + user);
            }
        }
    }
}
