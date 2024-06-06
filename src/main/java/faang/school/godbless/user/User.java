package faang.school.godbless.user;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.disjoint;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public record User(Integer id, String name, String age, Set<String> activities) {

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> userActivities) {

        return users.stream()
                .filter(user -> disjoint(user.activities, userActivities))
                .collect(toMap(identity(),
                        user -> user.activities.stream().filter(userActivities::contains)
                                .findFirst()
                                .orElseGet(null)));
    }
}
