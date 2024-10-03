package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String adress;

    public static Map<Integer, List<User>> groupUsers (List<User> usersList){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : usersList) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

}
