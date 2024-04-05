package faang.school.godbless.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hm = new HashMap<>();

        for (User user : users) {
            Set<String> userActivity = user.getActivity();
            Set<String> intersection = new HashSet<>(activities);
            intersection.retainAll(userActivity);
            if (!intersection.isEmpty()) {
                hm.put(user, intersection.stream().findFirst().get());
            }
        }
        return hm;
    }
}
