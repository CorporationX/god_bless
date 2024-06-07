package faang.school.godbless.Task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {

    private String name;
    private int age;
    private String place;
    private String address;

    @Override
    public String toString() {
        return name;
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return (HashMap<Integer, List<User>>) userGroups;
    }

}