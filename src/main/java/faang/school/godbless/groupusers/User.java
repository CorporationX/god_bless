package faang.school.godbless.groupusers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> group = new HashMap<>();
        for (User user : users){
            int age = user.age;
            if (!group.containsKey(age)){
                group.put(age, new ArrayList<>());
            }
            group.get(age).add(user);
        }
        return group;
    }
}
