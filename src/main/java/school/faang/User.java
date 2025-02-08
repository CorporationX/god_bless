package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            if (user != null && !user.getName().isEmpty()) {
                users.add(user);
                map.put(user.getAge(), users);
            } else {
                System.out.println("user is null");
            }
        }
        return map;
    }

    public static void main(String[] args) {
        User user1 = new User("Bob", 25, "Bum", "New York");
        User user2 = new User("Sarah", 13, "Bulder", "Paris");
        User user3 = new User("John", 48, "Engeener", "Moscow");
        System.out.println(groupUsers(List.of(user1, user2, user3)));
    }
}
