package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activity;


    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> resultMap = new HashMap<>();
        users.stream().forEach(user -> {
            activity.stream().forEach(hobby -> {
                if (user.getActivity().contains(hobby)) {
                    resultMap.put(user, hobby);
                }
            });
        });

        return resultMap;
    }


}
