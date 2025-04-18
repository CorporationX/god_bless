package school.faang.bjs_68394;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;
    private static String users;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers() {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            int userAge = user.getAge();

            if (result.containsKey(userAge)) {
                result.get(userAge).add(user);
            } else {
                List<User> list = new ArrayList<>();
                list.add(user);
                result.put(userAge, list);
            }
        }

        return result;
    }
}
