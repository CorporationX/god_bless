package faang.school.godbless.BJS2_18425;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        if (users == null || activities == null) {
            return null;
        }
        return users.stream()
                .filter(user -> user.activities != null)
                .filter(user -> !Collections.disjoint(user.activities, activities))
                .collect(Collectors.toMap(
                        user -> user,
                        user -> user.activities.stream()
                                .filter(activities::contains)
                                .findFirst()
                                .orElse("")
                ));
    }
}
