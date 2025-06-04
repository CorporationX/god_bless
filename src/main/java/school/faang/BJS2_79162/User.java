package school.faang.BJS2_79162;

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

    public static Map<school.faang.User, String> findHobbyLovers(List<school.faang.User> users, Set<String> activity) {
        Map<school.faang.User, String> resultMap = new HashMap<>();
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
