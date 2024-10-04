package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String placeOFWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User u : users) {
            groupedUsersByAge.computeIfAbsent(u.getAge(), k -> new ArrayList<User>()).add(u);
        }
        return groupedUsersByAge;
    }
}