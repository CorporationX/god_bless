package school.faang;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter

public class User {
    private String name;
    private int age;

    public  User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user: users){
            if (!map.containsKey(user.age)){
                map.put(user.age, new ArrayList<>());
            }
            map.get(user.age).add(user);
        }
        return map;
    }
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
