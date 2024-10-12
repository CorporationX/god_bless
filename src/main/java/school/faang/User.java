package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    String name;
    int age;
    String work;
    String address;

    public User(String name, int age, String address, String work) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : users) {
            if (!userMap.containsKey(user.getAge()) || userMap.get(user.getAge()) == null) {
                List<User>  userMapList = new ArrayList<>();
                userMapList.add(user);
                userMap.put(user.getAge(), userMapList);
            } else {
                userMap.get(user.getAge()).add(user);
            }
        }
        return userMap;
    }
}