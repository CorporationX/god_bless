package ru.kraiush.BJS2_31345;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUsersV1(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    public static Map<Integer, List<User>> groupUsersV2(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            if (!groupedUsersByAge.containsKey(user.getAge())) {
                List<User> userGroup = new ArrayList<>();
                userGroup.add(user);
                groupedUsersByAge.put(user.getAge(), userGroup);
            } else {
                groupedUsersByAge.get(user.getAge()).add(user);
            }
        }
        return groupedUsersByAge;
    }
}
