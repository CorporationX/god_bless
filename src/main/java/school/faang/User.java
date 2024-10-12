package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    String name;
    int age;
    String work;
    String address;

    public User(String name, int age, String address, String work) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
    }

    public static Map<Integer, List<User>> groupUsers (List<User> users){
        Map<Integer, List<User>> userMap = new HashMap<>();
        List<User> userMapKey = new ArrayList<>();

        for(User user : users){
            if(userMap.get(user.getAge()) != null) {
                userMapKey = userMap.get(user.getAge());
                if (!userMapKey.contains(user)){
                    userMap.get(userMapKey).add(user);
                }
            }
        }
        return userMap;
    }
}
