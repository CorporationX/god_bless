package school.faang.bjs2_79164;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class User {
    private final String name;
    private final int age;
    private final String placeWork;
    private final String address;

    public User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUserByAge = new HashMap<>();

        for (User user : users) {
            groupUserByAge.computeIfAbsent(user.getAge(), (key) -> new ArrayList<>()).add(user);
        }

        return groupUserByAge;
    }

}
