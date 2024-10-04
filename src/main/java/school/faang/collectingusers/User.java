package school.faang.collectingusers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer  id;
    String name;
    Integer age;
    Set<String> activity;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> userMap = new HashMap<>();
        for (User user : users) {
            for (String oneActivity: activity) {
                if (user.getActivity().contains(oneActivity)) {
                    userMap.put(user, oneActivity.toString());
                }
            }
        }
        return userMap;
    }
}
