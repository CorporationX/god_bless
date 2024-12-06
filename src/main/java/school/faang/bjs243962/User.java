package school.faang.bjs243962;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activitiesToCheck) {

        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (activitiesToCheck.contains(activity)) {
                    System.out.printf("For user: %s, the following activity match found: %s \r\n",
                            user.name, activity);
                    result.put(user, activity);
                }
            }
        }

        return result;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activitiesToCheck,
                                                    boolean useCollections) {

        return users.stream()
                .flatMap(user -> user.activities.stream()
                        .filter(activitiesToCheck::contains)
                        .map(activity -> Map.entry(user, activity)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, HashMap::new));
    }
}
