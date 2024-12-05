package school.faang.moduleone.task_43504;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            Optional<String> matchingActivityOpt = getMatchingActivity(user, activities);
            if (matchingActivityOpt.isPresent()) {
                result.put(user, matchingActivityOpt.get());
            }
        }
        return result;
    }

    private static Optional<String> getMatchingActivity(User user, Set<String> activities) {
        return user.getActivities().stream()
                .filter(activities::contains)
                .findFirst();
    }
}
