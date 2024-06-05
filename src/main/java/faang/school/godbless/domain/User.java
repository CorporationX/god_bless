package faang.school.godbless.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private Integer age;
    private String work;
    private String address;

    public Integer getAge() {
        return age;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            if (!groupUsers.containsKey(user.getAge()))
                groupUsers.put(user.getAge(), new ArrayList<>());
            groupUsers.get(user.getAge()).add(user);
        }
        return groupUsers;
    }


}

