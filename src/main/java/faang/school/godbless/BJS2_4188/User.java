package faang.school.godbless.BJS2_4188;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> hobbies) {
        Map<User, String> results = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbies.contains(hobby)) {
                    results.put(user, hobby);
                    break;
                }
            }
        }
        return results;
    }
}
