package com.basic;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, List<String> allActivities) {
        Map<User, String> userActivitiesMap = new HashMap<>();
        if (allActivities != null) {
            for (User user : users) {
                for (String activ : allActivities) {
                    if (user.getActivities().contains(activ)) {
                        userActivitiesMap.put(user, activ);
                    }
                }
            }
            return userActivitiesMap;
        }
        return new HashMap<>();
    }
}
