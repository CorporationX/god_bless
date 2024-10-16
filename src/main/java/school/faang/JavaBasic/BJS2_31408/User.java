package school.faang.JavaBasic.BJS2_31408;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers (List<User> users){
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for(User user: users){
            int usersAge = user.getAge();
            groupedUsersByAge.putIfAbsent(usersAge, new ArrayList<>());
            groupedUsersByAge.get(usersAge).add(user);
        }
        return groupedUsersByAge;
    }
}
