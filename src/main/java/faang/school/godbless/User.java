package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;

    private String placeOfWork;

    private String adress;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapUser = new HashMap<>();

        for (User user : users) {
            mapUser.put(user.getAge(), users);
        }

        return mapUser;
    }


}
