package school.faang.usergrouping;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private static final List<User> USERS = new ArrayList<>();

    private String name;
    private int age;
    private String organization;
    private String address;

    public User(String name, int age, String organization, String address) {
        this.name = name;
        this.age = age;
        this.organization = organization;
        this.address = address;
    }

    public static void main(String[] args) {
        User kolya = new User("Kolya", 25, "Google", "California");
        User vasya = new User("Vasya", 30, "Facebook", "California");
        User petya = new User("Petya", 25, "Google", "California");

        USERS.add(kolya);
        USERS.add(vasya);
        USERS.add(petya);

        System.out.println(groupUsers(USERS));
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", organization='" + organization + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
