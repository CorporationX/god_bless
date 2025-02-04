package school.faang.usergrouping;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Kolya", 25, "Google", "California"),
                new User("Vasya", 30, "Facebook", "California"),
                new User("Petya", 25, "Google", "California"));

        System.out.println(groupUsers(users));
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, organization='%s', address='%s'}",
                name, age, workplace, address);
    }
}
