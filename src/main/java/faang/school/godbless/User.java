package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address){
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> result = new HashMap<>();
        for(User user: users){
            int userAge = user.age;
            if(!result.containsKey(userAge)){
                result.put(userAge, new ArrayList<>());
            }
            result.get(userAge).add(user);
        }
        return result;
    }
}
