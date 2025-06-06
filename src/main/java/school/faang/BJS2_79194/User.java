package school.faang.BJS2_79194;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobby;

    public Map<User, String> findHobbyLovers(Set<User> userSet, Set<String> hobbySet) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : userSet) {
            Optional<String> findingHobby = user.hobby.stream()
                    .filter(hobbySet::contains)
                    .findFirst();
            findingHobby.ifPresent(s -> hobbyLovers.put(user, s));
        }
        return hobbyLovers;
    }
}