package school.faang.bjs2_85703;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupByUserAge(List<User> users) {
        Map<Integer, List<User>> userList = new HashMap<>();
        for (User user : users) {
            Integer age = user.getAge();
            if (!userList.containsKey(age)) {
                userList.put(age, new ArrayList<>());
            }
            userList.get(age).add(user);
        }
        return userList;
    }
}