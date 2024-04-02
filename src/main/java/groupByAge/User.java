package groupByAge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersGroupByAge = new HashMap<>();
        List<User> usersList = new ArrayList<>();

        for (User user : users) {
            if(usersGroupByAge.containsKey(user.getAge())) {
            usersList = usersGroupByAge.get(user.getAge());
            usersList.add(user);
            usersGroupByAge.put(user.getAge(), usersList);
            usersList = new ArrayList<>();
            }
            else {
                usersList.add(user);
                usersGroupByAge.put(user.getAge(), usersList);
                usersList = new ArrayList<>();
            }

        }

        return usersGroupByAge;
    }
}
