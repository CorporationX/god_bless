package school.faang.bjs2_79149;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class User {
    private int id;
    @ToString.Include
    private String name;
    private int age;
    @Getter
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> resultMap = new HashMap<>();

        for (User user : users) {
            Set<String> userActivity = user.getActivity();
            String firstMatch = null;
            for (String activity : userActivity) {
                if (activities.contains(activity)) {
                    firstMatch = activity;
                    break;
                }
            }
            resultMap.put(user, firstMatch);
        }
        return resultMap;
    }
}
