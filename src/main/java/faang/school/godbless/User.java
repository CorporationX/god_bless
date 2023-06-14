package faang.school.godbless;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;



    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            List<User> usersWithBirthdayInOneDay;
            if (!result.containsKey(user.age)) {
                usersWithBirthdayInOneDay = new ArrayList<>();
            } else {
                usersWithBirthdayInOneDay = result.get(user.age);
            }
            usersWithBirthdayInOneDay.add(user);
            result.put(user.age, usersWithBirthdayInOneDay);
        }
        return result;
    }
}





