package faang.school.godbless.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;

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
    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> userMap = new HashMap<Integer, List<User>>();
        for (User user : userList){
//            Intellij black magic lol, extremely handy method fr, I also love how its lambda func. Js dev in me is very happy
            List<User> users = userMap.computeIfAbsent(user.age, k -> new ArrayList<User>());
            users.add(user);
        }
        return userMap;
    }
}

