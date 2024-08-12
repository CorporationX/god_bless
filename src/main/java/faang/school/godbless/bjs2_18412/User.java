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
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        var userActivity = new HashMap<User, String>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    userActivity.put(user, activity);
                    break;
                }
            }
        }
        return userActivity;
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
