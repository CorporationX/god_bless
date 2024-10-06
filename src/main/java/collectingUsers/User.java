package collectingUsers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> hobbyLovers = new HashMap<User, String>();
        users.forEach(user -> {
            for (String activ : activity) {
                if (user.getActivity().contains(activ)) {
                    hobbyLovers.put(user, activ);
                    break;
                }
            }
        });
        return hobbyLovers;
    }
}
