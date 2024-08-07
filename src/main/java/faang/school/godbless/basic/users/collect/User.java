package faang.school.godbless.basic.users.collect;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public HashMap<Integer, String> findHobbyLovers(User user, Set<String> hobbies) {
        HashMap<Integer, String> map = new HashMap<>();
            for (String hobby: hobbies) {
                if (user.hobbies.contains(hobby)) {
                    map.put(user.id, hobby);
                    return map;
                }
            }
        return map;
    }

    public static Map<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        Map<Integer, ArrayList<User>> userMap = new HashMap<>();

        for (User user: users) {
            userMap.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return userMap;
    }

    @Override
    public String toString() {
        return name;
    }
}
