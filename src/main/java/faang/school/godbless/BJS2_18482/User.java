package faang.school.godbless.BJS2_18482;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
public class User {

    private String name;
    private int age;
    private String placeJob;
    private String address;

    public static Map<Integer, List<String>> groupUsers(List<User> users) {
        Map<Integer, List<String>> userMap = new HashMap<>();
        for(User user : users) {
            List userList = userMap.get(user.getAge());
            if (userList == null) {
                userList = new ArrayList<>();
                userMap.put(user.getAge(), userList);
            }
            userList.add(user);
        }
        return userMap;
    }

    public int getAge() {
        return age;
    }

}
