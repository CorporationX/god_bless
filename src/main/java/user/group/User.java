package user.group;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
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
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            return null;
        }
        Map<Integer, List<User>> ageMap = new HashMap<>();
        for(User user : users) {
            if (!ageMap.containsKey(user.getAge())) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                ageMap.put(user.getAge(), userList);
            }
            else {
                ageMap.get(user.getAge()).add(user);
            }
        }

        return ageMap;
    }
}
