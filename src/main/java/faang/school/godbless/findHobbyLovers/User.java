package faang.school.godbless.findHobbyLovers;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> usersList, Set<String> activities) {
        System.out.println("hi!");
        return usersList.stream()
                .filter(el -> el.getActivities().stream().anyMatch(activities::contains))
                .peek(el -> System.out.println(el.getId()))
                .collect(
                        Collectors.toMap(
                                el -> el,
                                el -> el.getActivities().stream()
                                        .filter(activities::contains)
                                        .limit(1)
                                        .findFirst()
                                        .get()
                        )
                );
    }
}
