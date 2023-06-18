package faang.school.godbless.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class UserWithHobby {
    private long id;
    private String name;
    private byte age;
    private Set<String> hobbies;

    public static Map<UserWithHobby, String> findHobbyLovers(List<UserWithHobby> users, Set<String> hobbies) {
        return users.stream()
            .filter(user -> !user.getHobbies().isEmpty())
            .flatMap(user -> user.getHobbies().stream()
                .filter(hobbies::contains)
                .findFirst()
                .map(hobby -> Map.entry(user, hobby))
                .stream())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
