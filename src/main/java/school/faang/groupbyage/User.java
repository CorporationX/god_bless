package school.faang.groupbyage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.address = address;
        this.workplace = workplace;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User {name=%s, age=%d, workplace=%s, address=%s}",
                name, age, workplace, address);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            result.putIfAbsent(age, new ArrayList<User>());
            result.get(age).add(user);
        }
        return result;
    }
}
