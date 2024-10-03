package school.faang.usercollection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@AllArgsConstructor
@Data
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> hobby;


    public static Map<User, String> findHobbyLovers(List<User> users,
                                              Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            Set<String> commonHobbies = new HashSet<>(user.getHobby());
            commonHobbies.retainAll(hobbies);
            if (!commonHobbies.isEmpty()) {
                String firstCommonHobby = commonHobbies.iterator().next();
                hobbyLovers.put(user, firstCommonHobby);
            }
        }
        return hobbyLovers;

    }
}
