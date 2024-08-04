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

        if (users != null) {
            for (Integer age : getAgeUser(users)) {
                List<User> userList = new ArrayList<>();
                for (User user : users) {
                    if (age == user.getAge()) {
                        userList.add(user);
                    }
                }
                userMap.put(age, userList);
            }
            return userMap;
        }
        return null;
    }

    private static Set<Integer> getAgeUser(List<User> users) {
        Set<Integer> setAge = new HashSet<>();
        for (User user : users) {
            setAge.add(user.getAge());
        }
        return setAge;
    }


}
