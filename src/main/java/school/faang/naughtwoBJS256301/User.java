package school.faang.naughtwoBJS256301;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobby;

    @Override
    public String toString() {
        return String.format("User: id- %d, name- %s, age- %d, hobby- %s",
                this.getId(), this.getName(), this.getAge(), this.getHobby());
    }

    public static Map<Integer, String> findHobbyLovers(List<User> users, Set<String> hobbySet) {
        Map<Integer, String> findHobby = new HashMap<>();
        for (User user : users) {
            for (String element : hobbySet) {
                Integer key = user.getId();
                if (!findHobby.containsKey(key) && user.hobby.contains(element)) {
                    findHobby.put(key, element);
                }
            }
        }
        return findHobby;
    }
}
