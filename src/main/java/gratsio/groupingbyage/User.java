package gratsio.groupingbyage;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            groupedUsersByAge.putIfAbsent(age, new ArrayList<>());
            groupedUsersByAge.get(age).add(user);
        }
        return groupedUsersByAge;
    }
}
