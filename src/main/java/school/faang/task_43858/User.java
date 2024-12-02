package school.faang.task_43858;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageGroupMap = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            if (!ageGroupMap.containsKey(age)) {
                ageGroupMap.put(age, new ArrayList<>());
            }
            ageGroupMap.get(age).add(user);
        }

        return ageGroupMap;
    }
}