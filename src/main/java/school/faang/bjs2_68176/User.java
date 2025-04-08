package school.faang.bjs2_68176;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            Integer age = user.getAge();
            List<User> userList = result.getOrDefault(age, new ArrayList<>());
            userList.add(user);
            result.put(age, userList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<User> users = List.of(
            new User("Vasya", 30, "place01", "post 001"),
            new User("Petr", 30, "place02", "post 001"),
            new User("Ivan", 23, "place03", "post 001"),
            new User("Nastya", 25, "place01", "post 001"),
            new User("Egor", 25, "place02", "post 001")
        );

        Map<Integer, List<User>> userGroups = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : userGroups.entrySet()) {
            System.out.printf("Возраст: %d\n", entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
