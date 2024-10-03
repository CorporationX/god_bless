package school.faang.user_hobby_collection;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> usersList, List<String> hobbiesList) {
        Map<User, String> usersWithHobbyFromTheList = new HashMap<>();
        for (User user : usersList) {
            String firstMatchedHobby = null;
            for (String hobby : user.getHobbies()) {
                if (hobbiesList.contains(hobby)) {
                    firstMatchedHobby = hobby;
                    break;
                }
            }
            if (firstMatchedHobby != null) {
                usersWithHobbyFromTheList.put(user, firstMatchedHobby);
            }
        }
        for (Map.Entry<User, String> entry : usersWithHobbyFromTheList.entrySet()) {
            System.out.println(entry.getKey().getName() + "'s first hobby is: " + entry.getValue());
        }
        return usersWithHobbyFromTheList;
    }
}
