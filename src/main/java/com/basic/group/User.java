package com.basic.group;

import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        if (users.isEmpty() && getAgeUser(users).isEmpty()) {
            return new HashMap<>();
        }else {
            for (Integer age : getAgeUser(users)) {
                for (User user : users) {
                    if (age == user.getAge()) {
                        userMap.computeIfAbsent(user.getAge(), v -> new ArrayList<>()).add(user);
                    }
                }
            }
            return userMap;
        }
    }

    private static Set<Integer> getAgeUser(List<User> users) {
        Set<Integer> setAge = new HashSet<>();
        for (User user : users) {
            if (user.getAge() < 0) {
                return new HashSet<>();
            }
            setAge.add(user.getAge());
        }
        return setAge;
    }
}
