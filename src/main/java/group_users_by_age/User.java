package group_users_by_age;

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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer,List<User>> groupedMapByAge = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            if (groupedMapByAge.containsKey(age)) {
                groupedMapByAge.get(age).add(user);
            } else {
                ArrayList<User> usersWithSameAge = new ArrayList<>();
                usersWithSameAge.add(user);
                groupedMapByAge.put(age,usersWithSameAge);
            }
        }
        return groupedMapByAge;
    }
}
