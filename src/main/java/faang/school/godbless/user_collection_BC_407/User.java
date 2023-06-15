package faang.school.godbless.user_collection_BC_407;

import java.util.*;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private int age;
    private final Set<String> activities = new HashSet<>();

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activitiesSet) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            Optional<String> activity = user.activities.stream()
                    .filter(activitiesSet::contains)
                    .findFirst();
            activity.ifPresent(s -> hobbyLovers.put(user, s));
        }
        return hobbyLovers;
    }

    public Map<User, String> findHobbyLovers2(List<User> users, Set<String> activities) {
        Map<User, String> similarUsers = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.activities.contains(activity) && !similarUsers.containsKey(user)) {
                    similarUsers.put(user, activity);
                    break;
                }
            }
        }
        return similarUsers;
    }
}
