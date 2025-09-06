package school.faang.java_core.bjs2_85461;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null || users.isEmpty()) {
            System.out.println("Пустой список или на входе null");
            return Collections.emptyMap();
        }
        Map<Integer, List<User>> mapUsers = new HashMap<>();

        for (User user : users) {
            if (mapUsers.containsKey(user.getAge())) {
                mapUsers.get(user.getAge()).add(user);
            } else {
                List<User> newUsers = new ArrayList<>();
                newUsers.add(user);
                mapUsers.put(user.getAge(), newUsers);
            }
        }
        return mapUsers;
    }
}
