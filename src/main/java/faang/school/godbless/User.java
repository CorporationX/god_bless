package faang.school.godbless;

import lombok.Data;
import lombok.val;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    String name;
    int age;
    String jobPlace;
    String adress;

    public static Map<Integer,List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> matchedHobbyUsers = new HashMap<>();
        for (User user : users) {
            matchedHobbyUsers.put(user.age, users.stream().filter(user1 -> user1.age == user.age).toList());
        }

        return matchedHobbyUsers;
    }
}
