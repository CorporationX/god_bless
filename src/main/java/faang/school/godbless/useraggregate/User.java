package faang.school.godbless.useraggregate;

import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

//@AllArgsConstructor
//@Data
public record User(String name, int age, String workplace, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user: users) {
            int userAge = user.age();
            if (!groupUsers.containsKey(userAge)) {
                groupUsers.put(userAge, new ArrayList<>(List.of(user)));
            } else {
                groupUsers.get(userAge).add(user);
            }
        }

        return groupUsers;
    }

}
