package user.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static HashMap<Integer, List<User>> sortingUsersByAge(List<User> users) {
        HashMap<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            usersByAge.putIfAbsent(user.getAge(), new ArrayList<>()).add(user);
        }

        return usersByAge;
    }
}
