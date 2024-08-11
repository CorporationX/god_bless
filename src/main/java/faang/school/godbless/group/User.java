package faang.school.godbless.group;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String workAddress;
    @NonNull
    private String homeAddress;

    public User(String name, Integer age,  String workAddress, String homeAddress) {
        if (age >= 18){
            this.name = name;
            this.age = age;
            this.homeAddress = homeAddress;
            this.workAddress = workAddress;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        var userMap = new HashMap<Integer, List<User>>();
        for (User user : userList){
            addUser(userMap, user);
        }
        return userMap;
    }

    private static void addUser(Map<Integer, List<User>> userMap, User user) {
        userMap.computeIfAbsent(user.age, k -> new ArrayList<>());
        userMap.get(user.age).add(user);
    }
}
