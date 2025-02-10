package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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
            if (isValidUser(user)) {
                if (!map.containsKey(user.getAge())) {
                    map.put(user.getAge(), new ArrayList<>());
                }
                map.get(user.getAge()).add(user);
            } else {
                log.info(" Invalid user skipped {}", user);
            }
        }
        return map;
    }

    public static boolean isValidUser(User user) {
        return user != null && !user.getName().isBlank() && !user.getAddress().isBlank()
                && !user.getWork().isBlank() && user.getAge() >= 0;


    }

    public static void main(String[] args) {
        User user1 = new User("Tom", 25, "Bum", "New York");
        User user2 = new User("Sarah", 13, "Builder", "");
        User user3 = new User("John", 48, "Engineer", "Moscow");
        User user4 = new User("Kukan", 25, "Bum", "New York");
        User user5 = new User("Lena", 13, "Builder", "Paris");
        List<User> list = new ArrayList(List.of(user1, user2, user3, user4, user5));
        System.out.println(groupUsers(list));
    }
}
