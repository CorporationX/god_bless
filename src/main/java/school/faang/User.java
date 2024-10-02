package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;


    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        return
                users.stream()
                        .flatMap(user -> user.getActivities()
                                .stream()
                                .filter(activities::contains)
                                .findFirst()
                                .map(activity -> Map.entry(user, activity))
                                .stream())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}