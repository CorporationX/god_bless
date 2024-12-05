package school.faang.task_43992;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupByAge = new HashMap<>();
        for (User user : users) {
            int key = user.getAge();
            if (groupByAge.containsKey(key)) {
                groupByAge.get(key).add(user);
            } else {
                groupByAge.put(key, new ArrayList<>());
                groupByAge.get(key).add(user);
            }
        }
        return groupByAge;
    }

    static void printUsers(Map<Integer, List<User>> users) {
        for (Map.Entry<Integer, List<User>> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
