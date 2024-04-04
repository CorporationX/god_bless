package faang.school.godbless.groupbyage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {

    private String name;
    private int age;
    private String jobPlace;
    private String address;

    public Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : users) {

            if (!userMap.containsKey(user.getAge())) {
                userMap.put(user.getAge(), new ArrayList<>());
            }

            userMap.get(user.getAge()).add(user);
        }

        return userMap;
    }

}
