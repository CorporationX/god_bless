package faang.school.godbless.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Я надеюсь коменты можно на английском писать, у меня клава только с английской расскладкой и я прям мучабсь писать на русском :)

//Assume User Object is immutable and all fields are required
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String companyName;
    private String address;

    //Quite self-explanatory
    public static Map<Integer, User> groupUsers(List<User> userList) {
        Map<Integer, User> userMap = new HashMap<Integer, User>();
        for (User user : userList){
            userMap.put(user.age ,user);
        }
        return userMap;
    }
}

