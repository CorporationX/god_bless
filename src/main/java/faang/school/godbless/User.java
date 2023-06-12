package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlease;
    private String address;


    public static HashMap<Integer, List<User>> groupUsers(List<User> users) {
        HashMap<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            if (!result.containsKey(user.age)){
                List<User> usersWithBirthdayInOneDay = new ArrayList<>();
                usersWithBirthdayInOneDay.add(user);
                result.put(user.age, usersWithBirthdayInOneDay);
            }
            else {
                List<User> result2 = result.get(user.age);
                result2.add(user);
                result.put(user.age, result2);
            }
        }
        return result;
    }
}





