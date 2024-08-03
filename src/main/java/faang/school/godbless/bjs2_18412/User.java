package faang.school.godbless.bjs2_18412;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
    private Integer age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        var result = new HashMap<User, String>();
        for (User user : users) {
            var userActivities = user.getActivities();
            for (String activity : userActivities) {
                if (activities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }

    public static Map<User, String> findHobbyLoversJava8(List<User> users, Set<String> activities) {
        return users.stream()
                .filter(user -> user.getActivities().stream().anyMatch(activities::contains))
                .collect(toMap(
                        identity(),
                        user -> user.getActivities().stream()
                                .filter(activities::contains)
                                .findFirst()
                                .get()
                ));
    }

    public static void printHobbyLovers(Map<User, String> hobbyLovers) {
        hobbyLovers.entrySet().forEach(System.out::println);
        System.out.println("----");
    }
}
