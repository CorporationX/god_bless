package faang.school.godbless.findhobbylovers;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
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

    public static Map<User, String> findHobbyLoversByLoopsAndIfs(List<User> usersList, Set<String> activities) {
        Map<User, String> resultMap = new HashMap<>();

        for (User user : usersList) {
            for (String userActiviti : user.getActivities()) {
                int resultMapSize = resultMap.size();

                for (String setActivity : activities) {
                    if (userActiviti.equals(setActivity)) {
                        resultMap.put(user, userActiviti);
                        break;
                    }
                }

                if (resultMapSize != resultMap.size()) {
                    break;
                }
            }
        }

        return resultMap;
    }

    public static Map<User, String> findHobbyLoversByStream(List<User> usersList, Set<String> activities) {
        return usersList.stream()
                .filter(el -> el.getActivities().stream().anyMatch(activities::contains))
                .collect(
                        Collectors.toMap(
                                el -> el,
                                el -> el.getActivities().stream()
                                        .filter(activities::contains)
                                        .limit(1)
                                        .findFirst()
                                        .orElse("")
                        )
                );
    }


}
