package school.faang.bjs2_85637;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String address;
    private String homeAddress;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : userList) {
            int age = user.getAge();

            usersByAge.putIfAbsent(age, new ArrayList<>());
            usersByAge.get(age).add(user);
        }

        for (Map.Entry<Integer, List<User>> entry : usersByAge.entrySet()) {
            System.out.printf("Age - %d: %s%n", entry.getKey(), entry.getValue());
        }
        return usersByAge;
    }
}
