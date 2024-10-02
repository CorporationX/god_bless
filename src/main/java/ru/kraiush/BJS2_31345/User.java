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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            groupedUsersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsersByAge;
    }
}
