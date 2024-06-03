package faang.school.godbless.useraggregate;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {
        Map<Integer, List<User>> mapUsers = new HashMap<>();
        for (User user: listUser) {
            int userAge = user.getAge();
            if (!mapUsers.containsKey(userAge)) {
                List<User> listUserToPut = new ArrayList<>();
                listUserToPut.add(user);
                mapUsers.put(userAge, listUserToPut);
            } else {
                mapUsers.get(userAge).add(user);
            }
        }

        return mapUsers;
    }

}
