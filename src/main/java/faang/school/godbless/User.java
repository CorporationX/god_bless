package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    private String name;

    private int age;

    private String placeOfWork;

    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapUser = new HashMap<>();

        for (User user : users) {

            List<User> users1 = mapUser.get(user.getAge());
            if (users1 != null) {
                users1.add(user);
            } else {
                List<User> newUsers = new ArrayList<>();
                newUsers.add(user);
                mapUser.put(user.getAge(), newUsers);
            }

        }

        return mapUser;
    }


}
