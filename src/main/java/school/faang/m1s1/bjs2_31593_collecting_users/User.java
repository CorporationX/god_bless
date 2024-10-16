package school.faang.m1s1.bjs2_31593_collecting_users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public Map<User, String> findHobbieLovers(List<User> userList, Set<String> targetHobbies) {
        Map<User, String> usersWithSimilarHobbies = new HashMap<>();
        for (User user : userList) {
            Set<String> friendsHobbies = user.getHobbies();
            for (String friendsHobby : friendsHobbies) {
                if (targetHobbies.contains(friendsHobby)) {
                    usersWithSimilarHobbies.put(user, friendsHobby);
                    break;
                }
            }
        }
        return usersWithSimilarHobbies;
    }
}
