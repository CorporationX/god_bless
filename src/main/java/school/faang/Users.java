package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Users {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<Users>> groupUsers(List<Users> users) {
        Map<Integer, List<Users>> usersGroupByAge = new HashMap<>();

        for (Users user : users) {
            int age = user.getAge();
            if (!usersGroupByAge.containsKey(age)) {
                usersGroupByAge.put(age, new ArrayList<>());
            }

            usersGroupByAge.get(age).add(user);
        }

        return usersGroupByAge;
    }
}
