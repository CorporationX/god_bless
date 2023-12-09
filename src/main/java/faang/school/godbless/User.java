package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;
    public User(String name, int age){
        this.age = age;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    static public Map<Integer, List<User>> groupUsers (List<User> userList){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for(User user : userList){
            int userAge = user.getAge();
            groupedUsers.putIfAbsent(userAge, new ArrayList<>());
            groupedUsers.get(userAge).add(user);
        }
        return groupedUsers;
    }
}
