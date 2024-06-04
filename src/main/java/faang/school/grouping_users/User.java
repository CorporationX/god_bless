package faang.school.grouping_users;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private String name;
    private int age;
    private String workingPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> result = new HashMap<>();

        for(User user : users){
            int age = user.age;
            result.computeIfAbsent(age, ageAsKey -> new ArrayList<>());
            result.get(age).add(user);
        }

        return result;
    }

}
