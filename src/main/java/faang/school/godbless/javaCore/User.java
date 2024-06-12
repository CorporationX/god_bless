package faang.school.godbless.javaCore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> hobbies) {

        Map<User, String> userActivityMap = new HashMap<>();
        for (User user : userList) {
            for (String currentHobby : hobbies) {
                if (user.getActivity().contains(currentHobby)) {
                    userActivityMap.put(user, currentHobby);
                }
            }
        }
        return userActivityMap;

    }


}
