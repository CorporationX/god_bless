package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user:users) {
            if (groupedUsers.containsKey(user.getAge())){
                    groupedUsers.get(user.getAge()).add(user);
            }else groupedUsers.computeIfAbsent(user.getAge(), newUser -> new ArrayList<>()).add(user);
        }return groupedUsers;

    }
}
