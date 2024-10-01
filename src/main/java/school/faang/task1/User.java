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

    public static Map<Integer, List<User>> sortUsers(List<User> users) {
        Map<Integer, List<User>> sortedUsers = new TreeMap<>();
        for (User user : users) {
            sortedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return sortedUsers;
    }

    public static void printSortedUsers(Map<Integer, List<User>> orderedUsers) {
        System.out.println("USERS SORTED BY AGE");
        for (Integer age : orderedUsers.keySet()) {
            System.out.println("Age:" + age);
            for (User user : orderedUsers.get(age)) {
                System.out.println("\t" + user);
            }
        }
    }
}
