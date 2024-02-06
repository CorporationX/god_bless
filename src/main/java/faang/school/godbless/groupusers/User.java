package faang.school.godbless.groupusers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workplace;
    private String adress;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (var user : users) {
            int age = user.getAge();
            if (groupedUsers.get(age) == null) {
                List<User> usersList = new ArrayList<>();
                usersList.add(user);
                groupedUsers.put(age, usersList);
            }
            else {
                groupedUsers.get(age).add(user);
            }
        }
        return groupedUsers;
    }
}
