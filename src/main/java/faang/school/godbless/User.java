package faang.school.godbless;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> groupUsers = new HashMap<>();
        for (User user: users){
            if (groupUsers.containsKey(user.age)){
                groupUsers.get(user.age).add(user);
            } else {
                groupUsers.put(user.age, new ArrayList<>());
                groupUsers.get(user.age).add(user);
            }
        }
        return groupUsers;
    }
}
