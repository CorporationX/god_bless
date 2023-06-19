package faang.school.godbless;
import lombok.ToString;

import java.util.*;

@ToString
public class User {
    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> res = new HashMap<>();
        for(User user : userList) {
            int age = user.age;
            if(!res.containsKey(age)) {
                List<User> list = new ArrayList<>();
                res.put(age, list);
            }
            res.get(age).add(user);


        }
        return res;
    }
}
