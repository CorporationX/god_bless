package faang.school.godbless.BJS27500;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private int age;
    private Set<String> actions;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> actions) {
        Map<User, String> result = new HashMap<>();

        users.forEach(user -> {
                    findFirstCommon(actions, user.getActions()).ifPresent(
                            commonElement -> result.put(user, commonElement));
        });
        return result;
    }

    private static Optional<String> findFirstCommon(Set<String> firstSet, Set<String> secondSet) {
        for (String string : firstSet) {
            if (secondSet.contains(string)) {
                return Optional.of(string);
            }
        }
        return Optional.empty();
    }

    public static void printFindFirstHobby(List<User> users, Set<String> actions) {
        User.findHobbyLovers(users, actions).forEach((key, value) -> System.out.println(key.getName() + " " + value));
    }
}
