package school.faang.sprint1task43927;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User currentUser : users) {
            int age = currentUser.getAge();
            if (!map.containsKey(currentUser.getAge())) {
                map.put(age, new ArrayList<>());
            }
            map.get(age).add(currentUser);
        }
        return map;
    }

}
