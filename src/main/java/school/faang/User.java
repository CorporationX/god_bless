package school.faang;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public static Map<User,String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbiesLovers = new TreeMap<>();
        for(User user: users) {
            for (String hobbi : user.getHobbies()) {
                if(hobbies.contains(hobbi)) {
                    hobbiesLovers.put(user,hobbi);
                }
            }
        }
        return hobbiesLovers;
    }


}