package dima.evseenko.group;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersMap = new HashMap();

        if(users == null){
            throw new IllegalArgumentException("users is null");
        }

        users.forEach(u -> groupedUsersMap.computeIfAbsent(u.getAge(), k -> new ArrayList<>()).add(u));
        return groupedUsersMap;
    }
}
