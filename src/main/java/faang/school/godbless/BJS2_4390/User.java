package faang.school.godbless.BJS2_4390;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static HashMap<Integer, List<User>> groupUsers(List<User> users) {

        HashMap<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            boolean groupExist = usersByAge.containsKey(age);

            if (!groupExist) {
                usersByAge.put(age, new ArrayList<>());
            }
            usersByAge.get(age).add(user);
        }

        return usersByAge;
    }
}
