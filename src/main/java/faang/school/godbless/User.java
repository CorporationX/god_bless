package faang.school.godbless;

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

    private String placeOfWork;

    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapUser = new HashMap<>();

        for (User user : users) {
            mapUser.putIfAbsent(user.getAge(), List.of(user));
        }

        return mapUser;
    }


}
