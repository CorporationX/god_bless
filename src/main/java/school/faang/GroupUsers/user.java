package school.faang.GroupUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class user {
private String n;
private int age;
private String workplace;
private String address;
    public static Map<Integer, List<user>> groupUsers(List<user> users) {
        Map<Integer, List<user>> result = new HashMap<>();
        for (user user : users) {
            int age = user.getAge();
            List<user> userList = result.get(age);
            if (userList == null) {
                userList = new ArrayList<>();
            }
            userList.add(user);
        }
        return result;
    }
}
