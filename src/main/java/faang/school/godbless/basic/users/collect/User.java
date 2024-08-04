package faang.school.godbless.basic.users.collect;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static HashMap<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        HashMap<Integer, ArrayList<User>> map = new HashMap<>();

        for (User user: users) {
            if (map.containsKey(user.age)) {
                ArrayList<User> userEntity = map.get(user.age);
                userEntity.add(user);
                map.put(user.age, userEntity);
            } else {
                map.put(user.age, new ArrayList<>(List.of(user)));
            }
        }
        return map;
    }

    @Override
    public String toString() {
        return name;
    }
}
