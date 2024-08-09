package faang.school.godbless.group_user_by_age;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class User {

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> userMap = new HashMap<>();


        for (User user : userList) {
            if (!userMap.containsKey(user.age)) {
                userMap.computeIfAbsent(user.age, list -> new ArrayList<>(List.of(user)));
            } else {
                List<User> existedUserList = userMap.get(user.age);

                List<User> updateUserList = new ArrayList<>(existedUserList);
                updateUserList.add(user);

                userMap.put(user.age, updateUserList);
            }
        }

        return userMap;
    }
}
