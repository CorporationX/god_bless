package school.faang.BJS2_68328;

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

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> usersGroupedByAge = new HashMap<>();
        for (User user : userList) {
            int userAge = user.getAge();
            if (usersGroupedByAge.containsKey(userAge)) {
                List<User> peers = usersGroupedByAge.get(userAge);
                peers.add(user);
                usersGroupedByAge.put(userAge, peers);
            } else {
                List<User> peers = new ArrayList<>();
                peers.add(user);
                usersGroupedByAge.put(userAge, peers);
            }
        }
        return usersGroupedByAge;
    }
}