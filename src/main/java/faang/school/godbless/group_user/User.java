package faang.school.godbless.group_user;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;


@Getter
@AllArgsConstructor
public class User {
    private String firstname;
    private int age;
    private String placeofwork;
    private String adds;


    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> groupedUser = new HashMap<>();
            for (User user : users) {
                groupedUser.computeIfAbsent(user.getAge(), value -> new ArrayList<>()).add(user);
            }
        return groupedUser;
    }
}


        


