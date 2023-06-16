package faang.school.godbless.task4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    @Getter
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> active) {
        Map<User, String> hobbyMap = new HashMap<>();

        for (User user : users) {
            for (String act : user.getActivity()) {
                if (active.contains(act)) {
                    hobbyMap.put(user, act);
                    break;
                }
            }
        }

        return hobbyMap;
    }
}

