package school.faang.task_43863;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            if (usersByAge.containsKey(user.getAge())) {
                usersByAge.get(user.getAge()).add(user);
            } else {
                List<User> newUserList = new ArrayList<>();
                newUserList.add(user);
                usersByAge.put(user.getAge(), newUserList);
            }
        }
        return usersByAge;

    }
}
