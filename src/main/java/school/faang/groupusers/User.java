package school.faang.groupusers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
public class User {
    private String name;
    @Getter
    private Integer age;
    private String workPlace;
    private String address;

    public static Map<Integer, User> getUsersWithAge(List<User> users, Integer age) {
        Map<Integer, User> sortedUsers = new HashMap<>();
        for (User user : users) {
            if (age.equals(user.getAge())) {
                sortedUsers.put(age, user);
            }
        }
        return sortedUsers;
    }
}
