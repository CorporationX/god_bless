package collectUsers;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> setActivity) {
        Map<User, String> usersHobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String loveHobby : user.getActivity()) {
                if (setActivity.contains(loveHobby)) {
                    usersHobbyLovers.put(user, loveHobby);
                }
            }
        }
        return usersHobbyLovers;
    }
}
