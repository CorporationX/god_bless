package school.faang.user_hobby_collection;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> usersList, Set<String> hobbiesSet) {
        Map<User, String> usersWithHobbyFromTheList = new HashMap<>();
        for (User user : usersList) {
            for (String hobby : user.getHobbies()) {
                if (hobbiesSet.contains(hobby)) {
                    usersWithHobbyFromTheList.put(user, hobby);
                    break;
                }
            }
        }
        for (Map.Entry<User, String> entry : usersWithHobbyFromTheList.entrySet()) {
            System.out.println(entry.getKey().getName() + "'s first matched hobby is: " + entry.getValue());
        }
        return usersWithHobbyFromTheList;
    }
}
