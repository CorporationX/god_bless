package school.faang.BJS2_31500;

import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import lombok.ToString;
import org.apache.commons.collections4.SetUtils;

@Getter
@ToString
public class User {
    private static int usersCount = 0;

    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(String name, int age, Set<String> hobbies) {
        validateName(name);
        validateAge(age);
        validateCollection(hobbies, "Invalid set of hobbies.");

        this.id = ++usersCount;
        this.name = name;
        this.age = age;
        this.hobbies = new HashSet<>(hobbies);
    }

    public static Map<User, Set<String>> findHobbyLovers(List<User> users, Set<String> hobbies) {
        validateCollection(users, "Invalid users list.");
        validateCollection(hobbies, "Invalid set of hobbies.");

        Map<User, Set<String>> usersHobbiesIntersection = new HashMap<>();
        users.forEach(user -> {
           Set<String> hobbiesIntersection = SetUtils.intersection(user.getHobbies(), hobbies);
           if (!hobbiesIntersection.isEmpty()) {
               usersHobbiesIntersection.put(user, hobbiesIntersection);
           }
        });
        return usersHobbiesIntersection;
    }

    private static void validateCollection(Collection<?> collection, String exceptionMessage) {
        //не использовал .contains(null), потому что для Set.of при проверке на null, выбрасывается NullPointerException
        if (collection == null || collection.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    private static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age. Must be at least 0 years old.");
        }
    }
}