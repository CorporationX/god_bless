package faang.school.godbless;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"name"})
@EqualsAndHashCode(of = {"id", "name"})
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Set<String> hobbies;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> otherHobbies) {
        Map<User, String> hobbyCoincidenceMap = new HashMap<>();
        for(User user : users) {
            for (String hobby : otherHobbies) {
                if (user.getHobbies().contains(hobby)) {
                    hobbyCoincidenceMap.put(user, hobby);
                    break;
                }
            }
        }
        return hobbyCoincidenceMap;
    }
}