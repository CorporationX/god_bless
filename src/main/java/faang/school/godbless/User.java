package faang.school.godbless;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class User {

    private int id;
    private String name;
    private int age;
    private HashSet<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, HashSet<String> activities) {

        return users.stream().filter(u -> {
            u.getActivities().retainAll(activities);
            return !u.getActivities().isEmpty();
        }).collect(Collectors.toMap(u -> u, u -> u.getActivities().iterator().next()));
    }

}
