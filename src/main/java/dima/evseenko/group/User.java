package dima.evseenko.group;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersMap = new HashMap<Integer, List<User>>();

        if(users == null){
            throw new IllegalArgumentException("users is null");
        }

        users.forEach(u -> {
            if(groupedUsersMap.containsKey(u.getAge())) {
                if(!groupedUsersMap.get(u.getAge()).contains(u)) {
                    groupedUsersMap.get(u.getAge()).add(u);
                }
            }else {
                List<User> userList = new ArrayList<User>();
                userList.add(u);
                groupedUsersMap.put(u.getAge(), userList);
            }
        });
        return groupedUsersMap;
    }
}
