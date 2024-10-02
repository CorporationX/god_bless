package school.faang;

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
    private Integer age;
    private String workingPlace;
    private String address;

    public User(String name, Integer age, String workingPlace, String address) {
        this.name = name;
        this.age = age;
        this.workingPlace = workingPlace;
        this.address = address;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : list) {
            userMap.computeIfAbsent(user.getAge(), u -> new ArrayList<>()).add(user);
        }
        return userMap;
    }
}
