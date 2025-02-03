package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());

    private Long id;
    private String name;
    private int age;
    private Set<String> hobbies;

    /**
     * Searches for users who have at least one of the specified activities.
     * If a user has multiple matching activities, only the first found activity is returned.
     *
     * @param users      the list of users to search through. Must not contain duplicates.
     * @param activities the set of activities to search for. Null or empty sets are ignored.
     * @return a map where the key is the user, and the value is the first matching activity.
     *         Returns an empty map if no matches are found.
     * @throws IllegalArgumentException if duplicate user IDs are detected.
     */
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        if (users == null || activities == null || activities.isEmpty()) {
            return new HashMap<>();
        }

        validateUniqueUsers(users);

        return users.stream()
                .filter(user -> user.getHobbies() != null)
                .flatMap(user -> activities.stream()
                        .filter(activity -> user.getHobbies().contains(activity))
                        .map(activity -> Map.entry(user, activity)))
                .collect(LinkedHashMap::new,
                        (map, entry) -> map.putIfAbsent(entry.getKey(), entry.getValue()),
                        Map::putAll);
    }

    /**
     * Validates that the list of users does not contain duplicate IDs.
     *
     * @param users the list of users to validate.
     * @throws IllegalArgumentException if duplicate user IDs are detected.
     */
    private static void validateUniqueUsers(List<User> users) {
        Set<Long> uniqueIds = new HashSet<>();
        for (User user : users) {
            if (!uniqueIds.add(user.getId())) {
                logger.warning("Duplicate user IDs detected: " + user.getId());
                throw new IllegalArgumentException("Duplicate user IDs detected: " + user.getId());
            }
        }
    }
}
